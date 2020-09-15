package me.bob.overheating;


import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.bob.overheating.events.blockboi;

public class overheating extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		 CustomOverheating.register();
		getCommand("CustomOverheating").setExecutor(new OverheatingEnable(this));

		this.getServer().getPluginManager().registerEvents(new blockboi(this), this);
	}

	public void onDisbale() {
		// ( <-- Start. End ---> )
	}

	
							}

							
						
	



		




