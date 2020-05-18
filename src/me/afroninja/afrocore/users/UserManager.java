package me.afroninja.afrocore.users;

import me.afroninja.afrocore.AfroCore;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class UserManager implements Listener {

    static UserManager instance = new UserManager();


    private static final HashMap<String, YamlConfiguration> allPlayers = new HashMap<String, YamlConfiguration>();

    public static UserManager getInstance() {
        return instance;
    }

    public static void addPlayer(Player player, YamlConfiguration userData) {
        if (!allPlayers.containsKey(player.getUniqueId().toString())) {
            allPlayers.put(player.getUniqueId().toString(), userData);
        }
    }

    public void savePlayer(String uuid) {
        if (allPlayers.containsKey(uuid)) {
//            new UserData(player).saveUserData();
            FileConfiguration data = allPlayers.get(uuid);
            try {
                data.save(getUserFile(uuid));
            } catch (IOException e) {
                e.printStackTrace();
            }
            allPlayers.remove(uuid);
        }
    }

    public void saveAll() {
        for (String uuid : allPlayers.keySet()){
            savePlayer(uuid);
        }
    }

    //    Events
    @EventHandler
    private void onPlayerLogin(PlayerLoginEvent e) {
        if (!getUserFile(e.getPlayer().getUniqueId().toString()).exists()) {
            addPlayer(e.getPlayer(), new UserData(e.getPlayer()).createNewUser());
        } else {
            addPlayer(e.getPlayer(), YamlConfiguration.loadConfiguration(new UserData(e.getPlayer()).getUserFile()) );
        }
    }

    @EventHandler
    private void onPlayerQuit(PlayerQuitEvent e) {
        savePlayer(e.getPlayer().getUniqueId().toString());
    }

    @EventHandler
    private void onPlayerKick(PlayerKickEvent e) {
        savePlayer(e.getPlayer().getUniqueId().toString());
    }


//    User File

    private File getUserFile(String uuid){
        return new File(AfroCore.getInstance().getDataFolder() + File.separator + "UserData", uuid + ".yml");
    }

    private File getUserFile(Player player){
        return new File(AfroCore.getInstance().getDataFolder() + File.separator + "UserData", player.getUniqueId().toString() + ".yml");
    }


//    User Data

    public YamlConfiguration getUserData(String uuid){
        return allPlayers.get(uuid);
    }

    public YamlConfiguration getUserData(Player player){
        return allPlayers.get(player.getUniqueId().toString());
    }
}
