package fraktalsk.FSMP.Potions;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CustomPotion {
	
	private int duration;
	private int potency;
	
	private PotionEffectType type;
	public String name;
	private Color color;
	private boolean isSplash;
	
	public CustomPotion(PotionEffectType pt, int du, int po, String nm, String hex, boolean sp) {
		type = pt;
		duration = du;
		potency = po;
		name = nm;
		color = Color.fromRGB(Integer.parseInt(hex, 16));
		isSplash = sp;
	}
	
	public ItemStack MakePotion() {
		ItemStack potion = new ItemStack(Material.POTION);
		
		if(isSplash) {
			potion.setType(Material.SPLASH_POTION);
		}
		
		PotionMeta meta = (PotionMeta) potion.getItemMeta();
		meta.setDisplayName(name);
		meta.addCustomEffect(new PotionEffect(type, duration, potency), true);
		meta.setColor(color);
		potion.setItemMeta(meta);		
		return potion;
	}
}
