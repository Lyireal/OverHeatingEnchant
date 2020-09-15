package me.bob.overheating;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class OverheatingEnable implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private overheating OH;
	public OverheatingEnable(overheating OH) {
		this.OH = OH;
	}
	
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("CustomOverheating")) {
				if (!(sender instanceof Player))
					return true;
				Player player = (Player) sender;
				
				ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
				item.addUnsafeEnchantment(CustomOverheating.OverHeating, 1);
				
				ItemMeta meta = item.getItemMeta();
				List<String> lore = new ArrayList<String>();
				lore.add(ChatColor.GRAY + "OverHeating");
				if (meta.hasLore())
					for (String l : meta.getLore())
						lore.add(l);
				meta.setLore(lore);
				item.setItemMeta(meta);
				
				player.getInventory().addItem(item);
				return true;

		}
		return true;
	}
	


}
