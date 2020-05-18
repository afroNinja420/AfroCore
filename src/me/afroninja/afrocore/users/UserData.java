package me.afroninja.afrocore.users;

import me.afroninja.afrocore.AfroCore;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class UserData extends YamlConfiguration {
    Player user;
    File userFile;

    public UserData(Player player) {
        this.user = player;
        this.userFile = new File(AfroCore.getInstance().getDataFolder() + File.separator + "UserData", user.getUniqueId().toString() + ".yml");
    }

    public YamlConfiguration createNewUser() {
        this.set("uuid", this.user.getUniqueId().toString());
        this.set("userName", this.user.getName());
        this.set("displayName", this.user.getDisplayName());
        this.set("displayNameUpdateTimesRun", 0);
        this.set("flyTimer", false);
        this.set("flyTime", 0);

        saveUserData();
        return this;
    }

    public File getUserFile(){
        return this.userFile;
    }

    public void saveUserData() {
        try {
            this.save(this.userFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    User Variables

    public String getUUID() {
        return this.getString("uuid");
    }

    public String getUserName() {
        return this.getString("userName");
    }

    public String getDisplayName() {
        return this.getString("displayName");
    }

    public void setDisplayName(String value) {
        this.set("displayName", value);
        this.setDisplayNameUpdateTimesRun(Integer.toString(getDisplayNameUpdateTimesRun() + 1));
    }

    public int getDisplayNameUpdateTimesRun() {
        return this.getInt("displayNameUpdateTimesRun");
    }

    public void setDisplayNameUpdateTimesRun(String value) {
        this.set("displayNameUpdateTimesRun", value);
    }

    public boolean getFlyTimer() {
        return this.getBoolean("flyTimer");
    }

    public void setUFlyTimer(String value) {
        this.set("flyTimer", value);
    }

    public long getFlyTime() {
        return this.getLong("flyTime");
    }

    public void setUFlyTime(String value) {
        this.set("flyTime", value);
    }

}

