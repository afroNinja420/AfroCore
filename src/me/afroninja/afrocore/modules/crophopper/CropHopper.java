package me.afroninja.afrocore.modules.crophopper;

import me.afroninja.afrocore.AfroCore;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.Hopper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CropHopper implements Listener {

    private AfroCore afroCore;


    private static FileConfiguration loc;
    private static File locFile;

    private static List<String> items;

    private static CropHopper instance = new CropHopper();

    public static CropHopper getInstance() {
        return instance;
    }


    public void setup(AfroCore plugin) {
        afroCore = plugin;

        Bukkit.getPluginManager().registerEvents(new CropHopper(), afroCore);

        locFile = new File(afroCore.getDataFolder() + File.separator + "data", "crophopper-data.yml");
        loc = YamlConfiguration.loadConfiguration(locFile);

//        saveDefaultConfig();

        items = AfroCore.settings.getCropHopperItems();
    }

    public static void reloadConfig() {
        loc = YamlConfiguration.loadConfiguration(locFile);
        AfroCore.settings.reloadConfig();
    }

    @EventHandler
    public void onItemDrop(ItemSpawnEvent e) {
        String item = e.getEntity().getItemStack().getType().name();

        if (items.contains(item)) {
            int spawnX = e.getEntity().getLocation().getChunk().getX();
            int spawnZ = e.getEntity().getLocation().getChunk().getZ();
            String hopperSave = String.valueOf(spawnX + String.valueOf(spawnZ));
            if (loc.getString("hopper-locations." + hopperSave) != null) {
                e.setCancelled(true);
                Material itemType = e.getEntity().getItemStack().getType();
                int itemAmount = e.getEntity().getItemStack().getAmount();
                int hopperX = loc.getInt("hopper-locations." + hopperSave + "." + "x");
                int hopperY = loc.getInt("hopper-locations." + hopperSave + "." + "y");
                int hopperZ = loc.getInt("hopper-locations." + hopperSave + "." + "z");
                String hopperWorld = loc.getString("hopper-locations." + hopperSave + "." + "world");
                Location hopperLoc = new Location(Bukkit.getWorld(hopperWorld), hopperX, hopperY, hopperZ);
                Hopper hopper = (Hopper) hopperLoc.getBlock().getState();
                hopper.getInventory().addItem(new ItemStack(itemType, itemAmount));
            }
        }
        return;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onHopperPlace(BlockPlaceEvent e) {

        //Basic checks
        if (e.isCancelled()) return;
        if (e.getItemInHand() == null) return;
        ItemStack blockPlaced = e.getItemInHand();
        Player p = e.getPlayer();
        if (blockPlaced.getType() != Material.HOPPER) return;
        if (!blockPlaced.hasItemMeta() || !blockPlaced.getItemMeta().hasDisplayName()) return;
        if (!blockPlaced.getItemMeta().getDisplayName().equals(cc(AfroCore.settings.getCropHopperName()))) return;
        if (!blockPlaced.getItemMeta().getLore().contains(cc(AfroCore.settings.getCropHopperLore()))) return;

        int chunkX = e.getBlockPlaced().getChunk().getX();
        int chunkZ = e.getBlockPlaced().getChunk().getZ();
        int hopperX = e.getBlockPlaced().getX();
        int hopperY = e.getBlockPlaced().getY();
        int hopperZ = e.getBlockPlaced().getZ();
        String hopperSave = String.valueOf(chunkX) + String.valueOf(chunkZ);

        if (loc.getString("hopper-locations." + hopperSave) != null) {
            e.setCancelled(true);
            p.sendMessage(cc(AfroCore.settings.getCropHopperMessage("hopper-already-in-chunk")));
            return;
        }
        //Set and save values in .yml
        p.sendMessage(cc(AfroCore.settings.getCropHopperMessage("hopper-place-success")));
        loc.set("hopper-locations." + hopperSave + "." + "chunkx", chunkX);
        loc.set("hopper-locations." + hopperSave + "." + "chunkz", chunkZ);
        loc.set("hopper-locations." + hopperSave + "." + "x", hopperX);
        loc.set("hopper-locations." + hopperSave + "." + "y", hopperY);
        loc.set("hopper-locations." + hopperSave + "." + "z", hopperZ);
        loc.set("hopper-locations." + hopperSave + "." + "world", e.getBlockPlaced().getWorld().getName());
        try {
            loc.save(locFile);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onHopperBreak(BlockBreakEvent e) {

        //Basic checks
        if (e.isCancelled()) return;
        if (e.getBlock() == null) return;
        Block blockBroke = e.getBlock();
        Player p = e.getPlayer();
        if (blockBroke.getType() != Material.HOPPER) return;

        int chunkX = blockBroke.getChunk().getX();
        int chunkZ = blockBroke.getChunk().getZ();
        int hopperX = blockBroke.getX();
        int hopperY = blockBroke.getY();
        int hopperZ = blockBroke.getZ();
        String hopperSave = String.valueOf(chunkX) + String.valueOf(chunkZ);
        int cfgX = loc.getInt("hopper-locations." + hopperSave + "." + "x");
        int cfgY = loc.getInt("hopper-locations." + hopperSave + "." + "y");
        int cfgZ = loc.getInt("hopper-locations." + hopperSave + "." + "z");

        //Determine whether the hopper broken is a CropHopper
        if (loc.getString("hopper-locations." + hopperSave) == null) return;
        if (cfgX == hopperX && cfgY == hopperY && cfgZ == hopperZ) {
            //Cancel BlockBreakEvent and create CropHopper item
            ItemStack cropHopper = new ItemStack(Material.HOPPER);
            nameItemLore(cropHopper, cc(AfroCore.settings.getCropHopperName()), cc(AfroCore.settings.getCropHopperLore()));
            e.setCancelled(true);
            //Update values in .yml
            loc.set("hopper-locations." + hopperSave, null);
            try {
                loc.save(locFile);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            if (p.getGameMode() != GameMode.CREATIVE) {
                e.getBlock().getWorld().dropItem(blockBroke.getLocation(), cropHopper);
            }
            e.getBlock().setType(Material.AIR);
            p.sendMessage(cc(AfroCore.settings.getCropHopperMessage("hopper-break-success")));
        }
    }

    private static String cc(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    private static ItemStack nameItemLore(ItemStack item, String name, String lore) {
        ItemMeta meta = item.getItemMeta();
        List<String> lores = new ArrayList<String>();
        meta.setDisplayName(name);
        lores.add(lore);
        meta.setLore(lores);
        item.setItemMeta(meta);
        return item;
    }

    public static void cropHopperCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("afrocore.crophopper.use")) {
            if (args.length == 1 && args[0].equalsIgnoreCase("give") && sender instanceof Player) {
                Player target = Bukkit.getPlayer(sender.getName());
                ItemStack cropHopper = new ItemStack(Material.HOPPER);
                nameItemLore(cropHopper, cc(AfroCore.settings.getCropHopperName()), cc(AfroCore.settings.getCropHopperLore()));
                target.getInventory().addItem(cropHopper);
                sender.sendMessage(cc(AfroCore.settings.getCropHopperMessage("prefix") + AfroCore.settings.getCropHopperMessage("crophopper-given")));
            }
            if (args.length == 2 && args[0].equalsIgnoreCase("give")) {
                Player target = Bukkit.getPlayer(args[1]);
                ItemStack cropHopper = new ItemStack(Material.HOPPER);
                nameItemLore(cropHopper, cc(AfroCore.settings.getCropHopperName()), cc(AfroCore.settings.getCropHopperLore()));
                target.getInventory().addItem(cropHopper);
                sender.sendMessage(cc(AfroCore.settings.getCropHopperMessage("prefix") + AfroCore.settings.getCropHopperMessage("crophopper-success")));
                target.sendMessage(cc(AfroCore.settings.getCropHopperMessage("prefix") + AfroCore.settings.getCropHopperMessage("crophopper-given")));
            }
            if (args.length == 0 || (args.length == 1 && args[0].equalsIgnoreCase("help"))) {
                sender.sendMessage(cc(AfroCore.settings.getCropHopperMessage("prefix")));
                sender.sendMessage(ChatColor.AQUA + "/crophopper give" + ChatColor.GRAY + " Give yourself a CropHopper.");
                sender.sendMessage(ChatColor.AQUA + "/crophopper give [player]" + ChatColor.GRAY + " Give another player a CropHopper.");
                sender.sendMessage(ChatColor.AQUA + "/crophopper list" + ChatColor.GRAY + " List all collected items.");
                sender.sendMessage(ChatColor.AQUA + "/crophopper add [item]" + ChatColor.GRAY + " Add item to collection list.");
                sender.sendMessage(ChatColor.AQUA + "/crophopper remove [item]" + ChatColor.GRAY + " Remove item from collection list.");
                sender.sendMessage(ChatColor.AQUA + "/crophopper reload" + ChatColor.GRAY + " Reload cfguration file.");
            }
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("list")) {
                    sender.sendMessage(ChatColor.GOLD + "CropHopper - Collected items: ");
                    sender.sendMessage(ChatColor.WHITE + items.toString().replace("[", "").replace("]", ""));
                    return;
                }
                if (args[0].equalsIgnoreCase("reload")) {
                    reloadConfig();
                    sender.sendMessage(ChatColor.GOLD + "CropHopper: Reloading cfguration.");
                    return;
                }
            }
            if (args.length == 2) {
                if (args[0].equalsIgnoreCase("add") && !items.contains(args[1].toUpperCase())) {
                    items.add(args[1].toUpperCase());
                    if (AfroCore.settings.setCropHopperItems(items)) {
                        sender.sendMessage(ChatColor.DARK_RED + "Added '" + ChatColor.AQUA + args[1].toUpperCase() + ChatColor.DARK_RED + "' to collection list!");
                    } else {
                        sender.sendMessage(ChatColor.DARK_RED + "Could not add '" + ChatColor.AQUA + args[1].toUpperCase() + ChatColor.DARK_RED + "' to collection list!");
                    }
                    return;
                }
                if (args[0].equalsIgnoreCase("remove") && items.contains(args[1].toUpperCase())) {
                    items.remove(args[1].toUpperCase());
                    if (AfroCore.settings.setCropHopperItems(items)) {
                        sender.sendMessage(ChatColor.DARK_RED + "Removed '" + ChatColor.AQUA + args[1].toUpperCase() + ChatColor.DARK_RED + "' from collection list!");
                    } else {
                        sender.sendMessage(ChatColor.DARK_RED + "Could not remove '" + ChatColor.AQUA + args[1].toUpperCase() + ChatColor.DARK_RED + "' from collection list!");
                    }
                    return;
                }
            }
        }
    }
}