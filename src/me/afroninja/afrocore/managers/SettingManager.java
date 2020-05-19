package me.afroninja.afrocore.managers;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import me.afroninja.afrocore.AfroCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;

public class SettingManager {
    private AfroCore afroCore;

    private FileConfiguration config;
    private File cfile;

    static SettingManager instance = new SettingManager();

    public static SettingManager getInstance() {
        return instance;
    }

    public void setup(AfroCore plugin) {
        afroCore = plugin;
        if (!afroCore.getDataFolder().exists()) {
            afroCore.getDataFolder().mkdir();
        }
        cfile = new File(afroCore.getDataFolder(), "config.yml");

        if (!cfile.exists()) {
            try{
                File en = new File(afroCore.getDataFolder(), "/config.yml");
                InputStream E = getClass().getResourceAsStream("/config.yml");
                copyFile(E, en);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        reloadConfig();

    }

    public FileConfiguration getConfig() {
        return config;
    }

    public PluginDescriptionFile getDesc() {
        return afroCore.getDescription();
    }

    public Boolean saveConfig() {
        try {
            config.save(cfile);
            reloadConfig();
            return true;
        } catch (IOException e) {
            Bukkit.getLogger().severe(ChatColor.RED + "Could not save config.yml!");
            return false;
        }
    }

    public void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(cfile);
    }

    private static void copyFile(InputStream in, File out) throws Exception { // https://bukkit.org/threads/extracting-file-from-jar.16962/
        InputStream fis = in;
        FileOutputStream fos = new FileOutputStream(out);
        try {
            byte[] buf = new byte[1024];
            int i = 0;
            while ((i = fis.read(buf)) != -1) {
                fos.write(buf, 0, i);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (fis != null) {
                fis.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }


//    Getters & Setters

    private Boolean set(String path, Object value){
        try {
            config.set(path, value);
            saveConfig();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean moduleEnabled(String module){
        return config.getBoolean(module + ".enabled");
    }

    public String getPrefix(){
        return config.getString("prefix");
    }

    public void setPrefix(String value){
        config.set("prefix", value);
    }


//    DEBUG
//    public boolean debugEnabled() {
//        return config.getBoolean("debug.enabled");
//    }

    public boolean debugEvent(String eventType, String eventName) {
        return config.getBoolean("debug.events." + eventType + "." + eventName);
    }





//    CropHopper

//    public boolean cropHopperEnabled() {
//        return config.getBoolean("crophopper.enabled");
//    }

    public List<String> getCropHopperItems() {
        return config.getStringList("crophopper.items");
    }

    public String getCropHopperName() {
        return config.getString("crophopper.hopper-name");
    }

    public String getCropHopperLore() {
        return config.getString("crophopper.hopper-lore");
    }

    public String getCropHopperMessage(String message) {
        return config.getString("crophopper.messages." + message);
    }

    public Boolean setCropHopperItems(List<String> items) {
        try {
            set("crophopper.items", items);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}