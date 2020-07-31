package me.derpee.toughcraft.commands;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import me.derpee.toughcraft.ToughCraft;

public class ToughToggleCommand implements CommandExecutor {
	Plugin plugin = ToughCraft.getPlugin(ToughCraft.class);
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length == 0) return false;
		
		List<String> eventList = ToughCraft.getEvents();
		
		if (eventList.contains(args[0])) {
			if (args.length >= 2) {
				if (args[1].equals("true")) {
					plugin.getConfig().set(args[0], true);
					plugin.saveConfig();
					Bukkit.broadcastMessage("§6§lTOUGH §r§8> " + "§e" + args[0] + "§r§7 is now " + "§r§6" + "true");
					return true;
				} else if (args[1].equals("false")) {
					plugin.getConfig().set(args[0], false);
					plugin.saveConfig();
					Bukkit.broadcastMessage("§6§lTOUGH §r§8> " + "§e" + args[0] + "§r§7 is now " + "§r§6" + "false");
					return true;
				}
				
				return false;
			} else {
				boolean eventToggle = plugin.getConfig().getBoolean(args[0]);
				
				plugin.getConfig().set(args[0], !eventToggle);
				plugin.saveConfig();
				Bukkit.broadcastMessage("§6§lTOUGH §r§8> " + "§e" + args[0] + "§r§7 is now " + "§r§6" + !eventToggle);
				return true;
			}
		} else {
			return false;
		}
	}
}
