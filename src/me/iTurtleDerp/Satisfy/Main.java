package me.iTurtleDerp.Satisfy;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
	public void onEnable()
	{
		getLogger().info("Satisfaction Enabled");
	}

	public void onDisable()
	{
		getLogger().info("Satisfaction Disabled");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		Server server = getServer();
		ConsoleCommandSender console = server.getConsoleSender();
		if(!(sender instanceof Player))
		{
			console.sendMessage(ChatColor.RED + "You have to be a player to use this command!");
		} 
		if(sender instanceof Player)
		{	
			Player player = (Player) sender;

			if(cmd.getName().equalsIgnoreCase("heal"))
			{
				if(player.hasPermission("satisfaction.heal"))
				{
					player.setHealth(20);
					player.sendMessage(ChatColor.GREEN + "You have been healed!");
				}
				else player.sendMessage(ChatColor.RED + "You do not have permission to heal yourself!");
			}
			if(cmd.getName().equalsIgnoreCase("feed"))
			{
				if(player.hasPermission("satisfaction.feed"))
				{
					player.setFoodLevel(20);
					player.sendMessage(ChatColor.GREEN + "You have been fed!");
				}
				else player.sendMessage(ChatColor.RED + "You do not have permission to feed yourself!");
			}
		}
		return true;
	}
}