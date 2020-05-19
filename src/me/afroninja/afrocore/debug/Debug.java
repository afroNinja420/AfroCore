package me.afroninja.afrocore.debug;

import me.afroninja.afrocore.AfroCore;
import me.afroninja.afrocore.debug.events.*;
import me.afroninja.afrocore.managers.SettingManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

public class Debug {

    static Debug instance = new Debug();
    SettingManager setting = AfroCore.settings;

    public static Debug getInstance() {
        return instance;
    }

    public void setup(Plugin plugin) {
        if (setting.debugEvent("Block", "enabled")) {
            Bukkit.getPluginManager().registerEvents(new BlockEvents(), plugin);
            Bukkit.getLogger().info("DEBUG: Block Events Logging");
        }

        if (setting.debugEvent("Enchantment", "enabled")) {
            Bukkit.getPluginManager().registerEvents(new EnchantmentEvents(), plugin);
            Bukkit.getLogger().info("DEBUG: Enchantment Events Logging");
        }

        if (setting.debugEvent("Entity", "enabled")) {
            Bukkit.getPluginManager().registerEvents(new EntityEvents(), plugin);
            Bukkit.getLogger().warning("DEBUG: Entity Events Logging");
        }

        if (setting.debugEvent("Inventory", "enabled")) {
            Bukkit.getPluginManager().registerEvents(new InventoryEvents(), plugin);
            Bukkit.getLogger().info("DEBUG: Inventory Events Logging");
        }

        if (setting.debugEvent("Painting", "enabled")) {
            Bukkit.getPluginManager().registerEvents(new PaintingEvents(), plugin);
            Bukkit.getLogger().info("DEBUG: Painting Events Logging");
        }

        if (setting.debugEvent("Player", "enabled")) {
            Bukkit.getPluginManager().registerEvents(new PlayerEvents(), plugin);
            Bukkit.getLogger().info("DEBUG: Player Events Logging");
        }

        if (setting.debugEvent("Server", "enabled")) {
            Bukkit.getPluginManager().registerEvents(new ServerEvents(), plugin);
            Bukkit.getLogger().info("DEBUG: Server Events Logging");
        }

        if (setting.debugEvent("Vehicle", "enabled")) {
            Bukkit.getPluginManager().registerEvents(new VehicleEvents(), plugin);
            Bukkit.getLogger().info("DEBUG: Vehicle Events Logging");
        }

        if (setting.debugEvent("Weather", "enabled")) {
            Bukkit.getPluginManager().registerEvents(new WeatherEvents(), plugin);
            Bukkit.getLogger().info("DEBUG: Weather Events Logging");
        }

        if (setting.debugEvent("World", "enabled")) {
            Bukkit.getPluginManager().registerEvents(new WorldEvents(), plugin);
            Bukkit.getLogger().info("DEBUG: World Events Logging");
        }
    }


    public static void logEvent(String string) {
        Bukkit.broadcastMessage(ChatColor.GOLD + "[EVENT] " + ChatColor.AQUA + string);
    }
}
