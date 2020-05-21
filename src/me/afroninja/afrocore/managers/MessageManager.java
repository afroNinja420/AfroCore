package me.afroninja.afrocore.managers;

import me.afroninja.afrocore.AfroCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MessageManager {
    private AfroCore afroCore;

    private FileConfiguration messages;
    private File messageFile;

    static MessageManager instance = new MessageManager();

    public static MessageManager getInstance() {
        return instance;
    }

    public void setup(AfroCore plugin) {
        afroCore = plugin;

        messageFile = new File(afroCore.getDataFolder(), "messages.yml");

        if (!messageFile.exists()) {
            try{
                File en = new File(afroCore.getDataFolder(), "/messages.yml");
                InputStream E = getClass().getResourceAsStream("/messages.yml");
                copyFile(E, en);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        reloadMessages();

    }
    
    public Boolean saveMessages() {
        try {
            messages.save(messageFile);
            reloadMessages();
            return true;
        } catch (IOException e) {
            Bukkit.getLogger().severe(ChatColor.RED + "Could not save messages.yml!");
            return false;
        }
    }

    public void reloadMessages() {
        messages = YamlConfiguration.loadConfiguration(messageFile);
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

    private Boolean set(String path, Object value){
        try {
            messages.set(path, value);
            saveMessages();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getString(String path){
        String message = ChatColor.translateAlternateColorCodes('&', messages.getString(path));

        message.replace("%prefix%", messages.getString("prefix"));

        return message;
    }
}
