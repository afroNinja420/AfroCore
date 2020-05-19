package me.afroninja.afrocore.debug.events;

import me.afroninja.afrocore.AfroCore;
import me.afroninja.afrocore.debug.Debug;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;

public class InventoryEvents  implements Listener {

    private boolean eventEnabled(String eventName){
        return AfroCore.settings.debugEvent("Inventory", eventName);
    }

    @EventHandler
    private void onBrew(BrewEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onCraftItem(CraftItemEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onFurnaceBurn(FurnaceBurnEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onFurnaceSmelt(FurnaceSmeltEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onInventoryClick(InventoryClickEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onInventoryClose(InventoryCloseEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onInventory(InventoryEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onInventoryOpen(InventoryOpenEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }
}
