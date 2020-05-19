package me.afroninja.afrocore.debug.events;

import me.afroninja.afrocore.AfroCore;
import me.afroninja.afrocore.debug.Debug;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;


public class BlockEvents implements Listener {

    private boolean eventEnabled(String eventName){
        return AfroCore.settings.debugEvent("Block", eventName);
    }

    @EventHandler
    private void onBlockBreak(BlockBreakEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
            Debug.logEvent(e.getPlayer().getName());
            Debug.logEvent(e.getBlock().getType().name());
            Debug.logEvent(e.getBlock().getLocation().toString());
        }
    }

    @EventHandler
    private void onBlockBurn(BlockBurnEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onBlockCanBuild(BlockCanBuildEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onBlockDamage(BlockDamageEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onBlockDispense(BlockDispenseEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onBlockFade(BlockFadeEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onBlockForm(BlockFormEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onBlockFromTo(BlockFromToEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onBlockGrow(BlockGrowEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
            Debug.logEvent(e.getBlock().getType().name());
            Debug.logEvent(e.getBlock().getLocation().toString());
            Debug.logEvent(e.getBlock().getState().toString());
        }
    }

    @EventHandler
    private void onBlockIgnite(BlockIgniteEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onBlockPhysics(BlockPhysicsEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onBlockPistonExtend(BlockPistonExtendEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onBlockPistonRetract(BlockPistonRetractEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onBlockPlace(BlockPlaceEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onBlockRedstone(BlockRedstoneEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onBlockSpread(BlockSpreadEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onEntityBlockForm(EntityBlockFormEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onLeavesDecay(LeavesDecayEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onNotePlay(NotePlayEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onSignChange(SignChangeEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }
}
