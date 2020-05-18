package me.afroninja.afrocore.modules;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Trash {

    public static void trashCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return;
        }

        if (!sender.hasPermission("afrocore.trash")) {
            sender.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
            return;
        }

        Player p = (Player) sender;
        Inventory inventory = Bukkit.createInventory(p, 27, "Trash");
        p.openInventory(inventory);
    }
}
