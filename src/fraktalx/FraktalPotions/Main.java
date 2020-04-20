package fraktalx.FraktalPotions;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

public class Main extends JavaPlugin implements Listener{

	//Material mat = Material.GLIS
	Map<String, CustomPotion> recipes = new HashMap<String, CustomPotion>();
	
	public static String VERSION = "v1.0";
	//type, duration, potency, name, colour, splash
	CustomPotion CONFUSION = new CustomPotion(PotionEffectType.CONFUSION, 2400, 1, "Potion of Confusion", "551d4a", false);
	CustomPotion CONFUSION_SPLASH = new CustomPotion(PotionEffectType.CONFUSION, 600, 1, "Splash Potion of Confusion", "551d4a", true);
	
	CustomPotion BLINDNESS = new CustomPotion(PotionEffectType.BLINDNESS, 2400, 3, "Potion of Blindness", "1f1f23", false);
	CustomPotion BLINDNESS_SPLASH = new CustomPotion(PotionEffectType.BLINDNESS, 600, 3, "Splash Potion of Blindness", "1f1f23", true);
	
	CustomPotion LEVITATION = new CustomPotion(PotionEffectType.LEVITATION, 200, 0, "Potion of Floating", "ceffff", false);
	CustomPotion LEVITATION_SPLASH = new CustomPotion(PotionEffectType.LEVITATION, 120, 0, "Splash Potion of Floating", "ceffff", true);
	
	CustomPotion ABSORPTION = new CustomPotion(PotionEffectType.ABSORPTION, 4800, 1, "Potion of Absorption", "2552a5", false);
	CustomPotion ABSORPTION_SPLASH = new CustomPotion(PotionEffectType.ABSORPTION, 1200, 1, "Splash Potion of Absorption", "2552a5", true);
	
	CustomPotion HUNGER = new CustomPotion(PotionEffectType.HUNGER, 3000, 0, "Potion of Starvation", "587653", false);
	CustomPotion HUNGER_SPLASH = new CustomPotion(PotionEffectType.HUNGER, 1000, 0, "Splash Potion of Starvation", "587653", true);
	
	CustomPotion HASTE = new CustomPotion(PotionEffectType.FAST_DIGGING, 9600, 1, "Potion of Haste", "d9c043", false);
	CustomPotion HASTE_SPLASH = new CustomPotion(PotionEffectType.FAST_DIGGING, 2400, 1, "Splash Potion of Haste", "d9c043", true);
	
	CustomPotion FATIGUE = new CustomPotion(PotionEffectType.SLOW_DIGGING, 9600, 1, "Potion of Fatigue", "4a4217", false);
	CustomPotion FATIGUE_SPLASH = new CustomPotion(PotionEffectType.SLOW_DIGGING, 2400, 1, "Splash Potion of Fatigue", "4a4217", true);
	
	CustomPotion GLOWING = new CustomPotion(PotionEffectType.GLOWING, 3600, 0, "Potion of Radiance", "94a061", false);
	CustomPotion GLOWING_SPLASH = new CustomPotion(PotionEffectType.GLOWING, 1200, 0, "Splash Potion of Radiance", "94a061", true);
	
	CustomPotion ANTIDOTE = new CustomPotion(PotionEffectType.DAMAGE_RESISTANCE, 100, 0, "Antidote", "ffffff", false);
	CustomPotion ANTIDOTE_SPLASH = new CustomPotion(PotionEffectType.DAMAGE_RESISTANCE, 100, 0, "Throwable Antidote", "ffffff", true);
	
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents((Listener) new BrewListener(this), (Plugin) this);
		this.getServer().getPluginManager().registerEvents((Listener) new PotionListener(), this);
		Bukkit.getLogger().info("FraktalPotions " + VERSION + " activated!");
		generateHashmap();
	}
	
	public void onDisable() {
		Bukkit.getLogger().info("FraktalPotions " + VERSION + " deactivated!");
	}
	
	public void generateHashmap() {
		recipes.put("WATER+SPIDER_EYE", CONFUSION);
		recipes.put("CONFUSION+GUNPOWDER", CONFUSION_SPLASH);
		
		recipes.put("WATER+GHAST_TEAR", BLINDNESS);
		recipes.put("BLINDNESS+GUNPOWDER", BLINDNESS_SPLASH);
		
		recipes.put("WATER+RABBIT_FOOT", LEVITATION);
		recipes.put("LEVITATION+GUNPOWDER", LEVITATION_SPLASH);
		
		recipes.put("WATER+BLAZE_POWDER", ABSORPTION);
		recipes.put("ABSORPTION+GUNPOWDER", ABSORPTION_SPLASH);
		
		recipes.put("WATER+SUGAR", HUNGER);
		recipes.put("HUNGER+GUNPOWDER", HUNGER_SPLASH);
		
		recipes.put("WATER+REDSTONE", HASTE);
		recipes.put("FAST_DIGGING+GUNPOWDER", HASTE_SPLASH);
		
		recipes.put("WATER+FERMENTED_SPIDER_EYE", FATIGUE);
		recipes.put("SLOW_DIGGING+GUNPOWDER", FATIGUE_SPLASH);
		
		recipes.put("WATER+GLOWSTONE_DUST", GLOWING);
		recipes.put("GLOWING+GUNPOWDER", GLOWING_SPLASH);
		
		recipes.put("WATER+GLISTERING_MELON_SLICE", ANTIDOTE);
		recipes.put("DAMAGE_RESISTANCE+GUNPOWDER", ANTIDOTE_SPLASH);
	}
}
