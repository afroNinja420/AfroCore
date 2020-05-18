package me.afroninja.afrocore.modules;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed {

    public static void feedCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return;
        }

        Player p = (Player) sender;

        if (args.length == 0) {
            if (!sender.hasPermission("afrocore.feed")) {
                sender.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
                return;
            }

            p.setFoodLevel(20);
            p.sendMessage(ChatColor.GREEN + "You have been fed!");
            return;
        }

        if (args.length == 1){
            if (args[0].equalsIgnoreCase("all")){
                if (!sender.hasPermission("afrocore.feed.all")) {
                    sender.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
                    return;
                }
                for (Player target : Bukkit.getOnlinePlayers()){
                    target.setFoodLevel(20);
                    target.sendMessage(ChatColor.GREEN + "You have been fed by " + p.getName() + "!");
                    p.sendMessage(ChatColor.GREEN + target.getName() + " has been fed!");
                }
                return;
            }
            if (!sender.hasPermission("afrocore.feed.others")) {
                sender.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
                return;
            }

            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (target == null){
                p.sendMessage(ChatColor.RED + "Could not find player " + args[0] + "!");
                return;
            }

            target.setFoodLevel(20);
            target.sendMessage(ChatColor.GREEN + "You have been fed by " + p.getName() + "!");
            p.sendMessage(ChatColor.GREEN + target.getName() + " has been fed!");
        }
    }
}
