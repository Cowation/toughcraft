package me.derpee.toughcraft;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.derpee.toughcraft.commands.ToughToggleCommand;
import me.derpee.toughcraft.completion.ToughToggleTabCompletion;

public class ToughCraft extends JavaPlugin implements Listener {
	public static List<String> getEvents() {
		List<String> list = new ArrayList<>();
		
		list.add("opMobs");
		list.add("craftingMonsters");
		list.add("damageShare");
		list.add("superSkeletons");
		
		return list;
	}
	
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new Listeners(), this);
		
		this.getCommand("toughtoggle").setExecutor(new ToughToggleCommand());
		this.getCommand("toughtoggle").setTabCompleter(new ToughToggleTabCompletion());
		
		for (String eventString : ToughCraft.getEvents()) {
			this.getConfig().addDefault(eventString, false);
		}
		
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
	}
	
	@Override
	public void onDisable() {
		
	}
}
