package fraktalsk.FSMP.Potions;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.BrewEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;

public class BrewListener implements Listener{
	Main main;
	
	public BrewListener(Main _main) {
		main = _main;
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onBrewEvent(BrewEvent c) {
		ItemStack[] contents = new ItemStack[] {c.getContents().getItem(0), c.getContents().getItem(1), c.getContents().getItem(2)};
		for(int i = 0; i < 3; i++) {
			if(contents[i] == null || contents[i].getType() == Material.AIR) continue;	

			if(((PotionMeta)contents[i].getItemMeta()).getBasePotionData().getType().toString() == "AWKWARD") continue;
			
			String type = "";
			if (((PotionMeta)contents[i].getItemMeta()).hasCustomEffects()) {
				type = ((PotionMeta)contents[i].getItemMeta()).getCustomEffects().get(0).getType().getName();
			} else if (((PotionMeta)contents[i].getItemMeta()).getBasePotionData().getType().getEffectType() == null) {
				type = "WATER";
			}

			String ingredient = c.getContents().getIngredient().getType().toString();
			
			CustomPotion cp = main.recipes.get(type + "+" + ingredient);
			if(cp == null) continue;
			c.getContents().setItem(i, cp.MakePotion());
		}
	}
}
