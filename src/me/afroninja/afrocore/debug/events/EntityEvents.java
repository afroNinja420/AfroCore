package me.afroninja.afrocore.debug.events;

import me.afroninja.afrocore.AfroCore;
import me.afroninja.afrocore.debug.Debug;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;

public class EntityEvents  implements Listener {

    private boolean eventEnabled(String eventName){
        return AfroCore.settings.debugEvent("Entity", eventName);
    }

    @EventHandler
    private void onCreatureSpawn(CreatureSpawnEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onCreperPower(CreeperPowerEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onEntityBreakDoor(EntityBreakDoorEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onEntityChangeBlock(EntityChangeBlockEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onEntityCombustByBlock(EntityCombustByBlockEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onEntityCombustByEntity(EntityCombustByEntityEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onEntityCombust(EntityCombustEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onEntityCreatePortal(EntityCreatePortalEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onEntityDamageByBlock(EntityDamageByBlockEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onEntityDamage(EntityDamageEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onEntityDeath(EntityDeathEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onEntityExplode(EntityExplodeEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onEntityInteract(EntityInteractEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onEntityPortalEnter(EntityPortalEnterEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onEntityRegainHealth(EntityRegainHealthEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onEntityShootBow(EntityShootBowEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onEntityTame(EntityTameEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onEntityTarget(EntityTargetEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onEntityTargetLivingEntity(EntityTargetLivingEntityEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onEntityTeleport(EntityTeleportEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onExpBottle(ExpBottleEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onExplosionPrime(ExplosionPrimeEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onFoodLevelChange(FoodLevelChangeEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onItemDespawn(ItemDespawnEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPigZap(PigZapEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerDeath(PlayerDeathEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPlayerLeashEntity(PlayerLeashEntityEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onPotionSplash(PotionSplashEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onSheepDyeWool(SheepDyeWoolEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onSheepRegrowWool(SheepRegrowWoolEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }

    @EventHandler
    private void onSlimeSplit(SlimeSplitEvent e) {
        if (eventEnabled(e.getEventName())) {
            Debug.logEvent(e.getEventName());
        }
    }
}
