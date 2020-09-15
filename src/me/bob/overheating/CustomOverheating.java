package me.bob.overheating;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.bukkit.enchantments.Enchantment;

public class CustomOverheating {
	
	public static final Enchantment OverHeating = new OverheatingWrapper("overheating", "overheating", 1);
	
	public static void register() {
		boolean registered = Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(OverHeating);
		
		if (!registered)
			registerEnchantment(OverHeating);
	}
	
	public static void registerEnchantment(Enchantment enchantment) {
		boolean registered = true;
		try {
			Field f = Enchantment.class.getDeclaredField("acceptingNew");
			f.setAccessible(true);
			f.set(null, true);
			Enchantment.registerEnchantment(enchantment);
		} catch(Exception e) {
			registered = false;
			e.printStackTrace();
		}
		if (registered) {
			//Sends a message to console
		}
		
		try {
			
			Enchantment.registerEnchantment(OverHeating);
		} catch (IllegalArgumentException e) {
		
		}
	}
}
