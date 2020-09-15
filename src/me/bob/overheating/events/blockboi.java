package me.bob.overheating.events;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Container;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import me.bob.overheating.CustomOverheating;
import me.bob.overheating.overheating;

public class blockboi implements Listener {
	
	@SuppressWarnings("unused")
	private overheating OH;
	public blockboi(overheating OH) {
		this.OH = OH;
	}
	
	@EventHandler()
	public void onBlockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		Material block = event.getBlock().getType();	
		if (!(event.getBlock().getState() instanceof Container))
			if (event.getPlayer().getGameMode() == GameMode.SURVIVAL)
				if (event.getPlayer().getInventory().getItemInMainHand() != null)
					if (event.getPlayer().getInventory().getItemInMainHand().hasItemMeta() == true)
						if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(CustomOverheating.OverHeating))
							if (event.getPlayer().getInventory().firstEmpty() >= 1) {
								
								

								if (player.hasPermission("gold")) {
									System.out.println("Block");
									if (block == Material.GOLD_ORE) {
											if (player.getInventory().getItemInMainHand().containsEnchantment(CustomOverheating.OverHeating)) {
												event.getPlayer().getWorld().dropItemNaturally(event.getBlock().getLocation(),new ItemStack(Material.GOLD_INGOT, 2));
												event.setCancelled(true);
												event.getBlock().setType(Material.AIR);
												System.out.println("Broke the gold ore.");
												
												}
											}
										}

									}
									if (player.hasPermission("iron")) {
										if (block == Material.IRON_ORE) {
											event.getPlayer().getWorld().dropItemNaturally(event.getBlock().getLocation(),new ItemStack(Material.IRON_INGOT, 1));
											event.setCancelled(true);
											event.getBlock().setType(Material.AIR);
											System.out.print("Broke the Iron Ore.");
										}
									}

								}

}
