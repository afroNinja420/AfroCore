package me.afroninja.afrocore.modules;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Repairable;

public class Repair {
    public static boolean repairCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;
        boolean all = false;

        if (cmd.getName().equalsIgnoreCase("repair")) {
            if (!player.hasPermission("afrocore.repair.use")) {
                player.sendMessage(ChatColor.RED + "You do not have permission to perform this command.");
                return true;
            }
            if (args.length >= 1) {
                if (args[0].equalsIgnoreCase("all") && player.hasPermission("afrocore.repair.all")) {
                    all = true;
                }
            }
            repairAll(player, all);
            player.sendMessage(ChatColor.GREEN + "You have repaired your tools and armor!");
            return true;
        }
        return false;
    }

    private static void repairAll(Player player, Boolean all) {
        for (ItemStack items : player.getInventory().getArmorContents()) {
            if (items instanceof Repairable) {
                items.setDurability((short) 0);
            }
        }
        if (all) {
            for (ItemStack items : player.getInventory().getContents()) {
                if (items instanceof Repairable) {
                    items.setDurability((short) 0);
                }
            }
            for (ItemStack items : player.getInventory().getArmorContents()) {
                if (items instanceof Repairable) {
                    items.setDurability((short) 0);
                }
            }
        } else {
            ItemStack item = player.getItemInHand();
            if (item instanceof Repairable) {
                item.setDurability((short) 0);
            }
        }
    }
}
