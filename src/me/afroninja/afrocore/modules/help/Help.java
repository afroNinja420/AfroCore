package me.afroninja.afrocore.modules.help;

import me.afroninja.afrocore.AfroCore;
import me.afroninja.afrocore.managers.SettingManager;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

public class Help {
    private static AfroCore afroCore = AfroCore.getInstance();
    private static SettingManager settings = SettingManager.getInstance();

    private static Logger log;


    public static void helpCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("help")) {

            if (args.length == 0){

            } else if (args.length == 1){
                if (args[0].equalsIgnoreCase("fly")){
                    printFly(sender);
                }

            }
            return;
        }
    }

    private static void printFly(CommandSender sender) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (sender.hasPermission("afrocore.fly.toggle.self")){
                printCommand(p, "fly", "Toggle flying");
            }
            if (sender.hasPermission("afrocore.fly.toggle.other")){
                printCommand(p, "fly <Player>", "Toggle flying for another player");
            }
            if (sender.hasPermission("afrocore.fly.speed.self")){
                printCommand(p, "fly speed <1-99>", "Set fly speed (%)");
            }
            if (sender.hasPermission("afrocore.fly.speed.other")){
                printCommand(p, "fly speed <player> <1-99>", "Set fly speed (%) for another player");
            }
            if (sender.hasPermission("afrocore.fly.timer")){
                printCommand(p, "flytimer <player> <time + s|m|h>", "Set fly timer for a player");
            }
        } else {
            log = Bukkit.getLogger();
            log.info(settings.getPrefix() + "&7- &b/fly &7- &2Toggle flying");
            log.info(settings.getPrefix() + "&7- &b/fly <Player> &7- &2Toggle flying for another player");
            log.info(settings.getPrefix() + "&7- &b/fly speed <Player> <1-99%> &7- &2Set fly speed for another player");
            log.info(settings.getPrefix() + "&7- &b/flytimer <Player> <Time + s|m|h> &7- &2Set fly timer for a player");
        }
    }

    private static void printCommand(Player player, String command, String description) {
        player.sendMessage(ChatColor.GRAY + "- " + ChatColor.DARK_AQUA + "/" + command + ChatColor.GRAY + " - " + ChatColor.RED + description);
    }

    public static void printHelp(){
        return;
    }
}
