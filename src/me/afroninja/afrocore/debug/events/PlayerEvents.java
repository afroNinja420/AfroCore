package me.afroninja.afrocore.debug.events;

import me.afroninja.afrocore.AfroCore;
import me.afroninja.afrocore.debug.Debug;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

public class PlayerEvents  implements Listener {

    private boolean eventEnabled(String eventName){
        return AfroCore.settings.debugEvent("Player", eventName);
    }

    @EventHandler
    private void onAsyncPlayerChat(AsyncPlayerChatEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onAsyncPlayerPreLogin(AsyncPlayerPreLoginEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerAnimation(PlayerAnimationEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerBedEnter(PlayerBedEnterEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerBedLeave(PlayerBedLeaveEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerBucketEmpty(PlayerBucketEmptyEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerBucketFill(PlayerBucketFillEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerChannel(PlayerChannelEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerChat(PlayerChatEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerChatTabComplete(PlayerChatTabCompleteEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerDropItem(PlayerDropItemEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerEggThrow(PlayerEggThrowEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerExpChange(PlayerExpChangeEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerFish(PlayerFishEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerGameModeChange(PlayerGameModeChangeEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerInteractEntity(PlayerInteractEntityEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerInteract(PlayerInteractEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerItemBreak(PlayerItemBreakEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerItemHeld(PlayerItemHeldEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerJoin(PlayerJoinEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerKick(PlayerKickEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerLevelChange(PlayerLevelChangeEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerLogin(PlayerLoginEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerMove(PlayerMoveEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerPickupItem(PlayerPickupItemEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerPortal(PlayerPortalEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerPreLogin(PlayerPreLoginEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerQuit(PlayerQuitEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerRegisterChannel(PlayerRegisterChannelEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerRespawn(PlayerRespawnEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerShearEntity(PlayerShearEntityEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerTeleport(PlayerTeleportEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerToggleFlight(PlayerToggleFlightEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerToggleSneak(PlayerToggleSneakEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerToggleSprint(PlayerToggleSprintEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerUnregisterChannel(PlayerUnregisterChannelEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerVelocity(PlayerVelocityEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }
}
