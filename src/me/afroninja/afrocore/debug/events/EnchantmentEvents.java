package me.afroninja.afrocore.debug.events;

import me.afroninja.afrocore.AfroCore;
import me.afroninja.afrocore.debug.Debug;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.*;

public class EnchantmentEvents  implements Listener {

    private boolean eventEnabled(String eventName){
        return AfroCore.settings.debugEvent("Enchantment", eventName);
    }

    @EventHandler
    private void onEnchantItem(EnchantItemEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
            Debug.logEvent(e.getEnchanter().getName());
            Debug.logEvent(e.getEnchantBlock().getLocation().toString());
            Debug.logEvent(e.getItem().getType().name());
            Debug.logEvent(e.getEnchantsToAdd().toString());
        }
    }

    @EventHandler
    private void onPrepareItemEnchant(PrepareItemEnchantEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
            Debug.logEvent((Integer.toString(e.getEnchantmentBonus())));
        }
    }
}
