package fraktalx.FraktalPotions;

import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PotionListener implements Listener{
	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerItemConsumeEvent(PlayerItemConsumeEvent c) {
		if(c.getItem() == null) return;
		if(!c.getItem().hasItemMeta()) return;
		if(((PotionMeta)c.getItem().getItemMeta()).getCustomEffects() != null && ((PotionMeta)c.getItem().getItemMeta()).getCustomEffects().size() > 0) {
			if(((PotionMeta)c.getItem().getItemMeta()).getCustomEffects().get(0).getType().getName() == "DAMAGE_RESISTANCE") {
				c.getPlayer().removePotionEffect(PotionEffectType.POISON);
			}
			
		}
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onSplashPotion(PotionSplashEvent c) {
		if(c.getAffectedEntities().size() == 0) return;
		if(c.getPotion() == null) return;
		Bukkit.broadcastMessage("epic2");
		if(c.getPotion().getEffects().size() > 0) {
			if(((PotionEffect)c.getPotion().getEffects().toArray()[0]).getType().getName() == "DAMAGE_RESISTANCE") {
				for (LivingEntity e : c.getAffectedEntities()) {
					e.removePotionEffect(PotionEffectType.POISON);
				}
			}
				
		}
	}
	
}
