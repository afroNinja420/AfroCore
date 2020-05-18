package me.afroninja.afrocore.managers;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

public class SettingManager {

    static SettingManager instance = new SettingManager();

    public static SettingManager getInstance() {
        return instance;
    }

    private Plugin p;

    private FileConfiguration config;
    private File cfile;

    public void setup(Plugin p) {
        if (!p.getDataFolder().exists()) {
            p.getDataFolder().mkdir();
        }
        cfile = new File(p.getDataFolder(), "Config.yml");

        if (!cfile.exists()) {
            try{
                File en = new File(p.getDataFolder(), "/Config.yml");
                InputStream E = getClass().getResourceAsStream("/Config.yml");
                copyFile(E, en);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        config = YamlConfiguration.loadConfiguration(cfile);

    }

    public FileConfiguration getConfig() {
        return config;
    }

    public PluginDescriptionFile getDesc() {
        return p.getDescription();
    }

    public void saveConfig() {
        try {
            config.save(cfile);
        } catch (IOException e) {
            Bukkit.getServer().getLogger()
                    .severe(ChatColor.RED + "Could not save Config.yml!");
        }
    }

    public void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(cfile);
    }

    public static void copyFile(InputStream in, File out) throws Exception { // https://bukkit.org/threads/extracting-file-from-jar.16962/
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


//    Setters and Getters

    private void set(String path, Object value){
        config.set(path, value);
        saveConfig();
        reloadConfig();
    }

    private String getString(String path){
        return config.getString(path);
    }

    private Boolean getBoolean(String path){
        return config.getBoolean(path);
    }

    private int getInt(String path){
        return config.getInt(path);
    }

    private Double getDouble(String path){
        return config.getDouble(path);
    }

    private Float getFloat(String path){
        return config.getFloat(path);
    }

    private Long getLong(String path){
        return config.getLong(path);
    }


//    Settings

    public String getPrefix(){
        return getString("prefix");
    }

    public void setPrefix(String value){
        set("prefix", value);
    }

    public boolean debugEnabled() {
        return getBoolean("debug.enabled");
    }

    public boolean debugEvent(String eventType, String eventName) {
        return getBoolean("debug.events." + eventType + "." + eventName);
    }
}