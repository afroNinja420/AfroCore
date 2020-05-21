package me.afroninja.afrocore;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class User implements Listener {

    private static final HashMap<UUID, User> users = new HashMap<>();

    private File userFile;
    private YamlConfiguration userConfig;

    private Player player;
    private UUID uuid;

    private String userName;
    private String displayName;
    private int displayNameChanges;

    private int balance;


    public User(Player player){
        this.player = player;
        this.uuid = player.getUniqueId();

        this.userFile = new File(AfroCore.getInstance().getDataFolder() + File.separator + "UserData", this.uuid.toString() + ".yml");
        if (!this.userFile.exists()) {
            try {
                this.userConfig.save(this.userFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.reload();

        this.setName();
        this.setDisplayName(player.getDisplayName());
        this.setBalance(AfroCore.settings.getStartBalance());

        registerPlayer(this);

        this.save();
    }



//    METHODS

    public static void registerPlayer(User user){
        if (!users.containsKey(user.getUUID())) {
            users.put(user.getUUID(), user);
        }
    }

    public static void unregisterPlayer(User user){
        user.save();
        users.remove(user.getUUID());
    }

    public static void unregisterAll(){

        for(Map.Entry<UUID, User> entry : users.entrySet()) {
            unregisterPlayer(entry.getValue());
        }

    }



    private void save() {
        try {
            this.userConfig.save(this.userFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void reload(){
        this.userConfig = YamlConfiguration.loadConfiguration(this.userFile);
    }



//    EVENTS

    @EventHandler
    private void onPlayerLogin(PlayerLoginEvent e) {
        new User(e.getPlayer());
    }

    @EventHandler
    private void onPlayerQuit(PlayerQuitEvent e) {
        unregisterPlayer(getUser(e.getPlayer().getUniqueId()));
    }


    @EventHandler
    private void onPlayerKick(PlayerKickEvent e) {
        unregisterPlayer(getUser(e.getPlayer().getUniqueId()));
    }



//    GETTERS & SETTERS

    private  void set(String path, Object value){
        userConfig.set(path, value);
        save();
        reload();
    }


    public static User getUser(UUID uuid) {
        return users.get(uuid);
    }


    public File getUserFile(){
        return this.userFile;
    }


    public UUID getUUID() {
        return this.uuid;
    }


    public Player getPlayer() {
        return this.player;
    }


    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int amount) {
        this.balance = amount;
        this.set("balance", amount);
    }


    public String getName() {
        return this.userName;
    }

    private void setName() {
        this.userName = this.player.getName();
        this.set("name", this.player.getName());
    }


    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
        this.displayNameChanges++;
        this.set("display-name", this.displayName);
        this.set("display-name-changes", this.displayNameChanges);
    }


    public int getDisplayNameUpdateTimesRun() {
        return this.displayNameChanges;
    }

    public void setDisplayNameUpdateTimesRun(int value) {
        this.displayNameChanges = value;
        this.set("display-name-changes", this.displayNameChanges);
    }


//    public boolean getFlyTimer() {
//        return this.getBoolean("flyTimer");
//    }
//
//    public void setUFlyTimer(String value) {
//        this.set("flyTimer", value);
//    }
//
//    public long getFlyTime() {
//        return this.getLong("flyTime");
//    }
//
//    public void setUFlyTime(String value) {
//        this.set("flyTime", value);
//    }





}