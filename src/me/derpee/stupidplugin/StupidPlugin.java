package me.derpee.stupidplugin;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class StupidPlugin extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new Listeners(), this);
	}
	
	@Override
	public void onDisable() {
		
	}
}
