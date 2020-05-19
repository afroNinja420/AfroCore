package me.afroninja.afrocore.debug.events;

import me.afroninja.afrocore.AfroCore;
import me.afroninja.afrocore.debug.Debug;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.painting.*;

public class PaintingEvents implements Listener {

    private boolean eventEnabled(String eventName){
        return AfroCore.settings.debugEvent("Painting", eventName);
    }

    @EventHandler
    private void onPaintingBreakByEntity(PaintingBreakByEntityEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPaintingBreak(PaintingBreakEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPaintingPlace(PaintingPlaceEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }
}
