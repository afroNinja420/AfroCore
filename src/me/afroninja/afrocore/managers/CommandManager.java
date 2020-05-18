package me.afroninja.afrocore.managers;

import me.afroninja.afrocore.modules.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import me.afroninja.afrocore.AfroCore;

public class CommandManager implements CommandExecutor, Listener {
    private AfroCore plugin = AfroCore.getInstance();


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("fly") || cmd.getName().equalsIgnoreCase("flytimer")) {
            Fly.flyCommand(sender, cmd, label, args);
        }

        if (cmd.getName().equalsIgnoreCase("help")) {
            Help.helpCommand(sender, cmd, label, args);
        }

        if (cmd.getName().equalsIgnoreCase("repair")) {
            Repair.repairCommand(sender, cmd, label, args);
        }

        if (cmd.getName().equalsIgnoreCase("trash")) {
            Trash.trashCommand(sender, cmd, label, args);
        }

        if (cmd.getName().equalsIgnoreCase("feed")) {
            Feed.feedCommand(sender, cmd, label, args);
        }

        if (cmd.getName().equalsIgnoreCase("heal")) {
            Heal.healCommand(sender, cmd, label, args);
        }

        return false;
    }
}
