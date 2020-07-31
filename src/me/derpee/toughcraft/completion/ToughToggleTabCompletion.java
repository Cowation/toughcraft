package me.derpee.toughcraft.completion;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import me.derpee.toughcraft.ToughCraft;

public class ToughToggleTabCompletion implements TabCompleter {
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1) {
			return ToughCraft.getEvents();
		} else if (args.length == 2) {
			List<String> list = new ArrayList<>();
			list.add("false");
			list.add("true");
			
			return list;
		}
		
		return null;
	}
}
