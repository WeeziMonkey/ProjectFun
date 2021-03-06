package src.nomarthehero.projectfun.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import src.nomarthehero.projectfun.ProjectFun;

public class LickCommand extends JavaPlugin implements CommandExecutor {
	
	/*
	 * COPY THIS WHOLE CLASS INTO A NEW CLASS FOR A NEW COMMAND
	 * 
	 * Replace "String command = null" with the command, for example "String command = slap" (make sure it's lowercase)
	 * Replace "String permission = null" with the permission you set it to in the plugin.yml, for example "String permission = projectfun.command.slap" (lowercase)
	 * 
	 * Make sure to register the command in ProjectFun
	 */
	
	ProjectFun PF = new ProjectFun();
	
	private String command = "lick";
	
	private String permission = "projectfun.lick";

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase(getCommand())) {
		
			if (sender instanceof Player) {
				
				Player player = (Player)sender;
				
				if (!player.hasPermission(getPerm())) {					
					return false;				
				}
				
				else {
					
					if (args.length == 0) {
						   sender.sendMessage(ChatColor.RED + "Not enough arguments!" + ChatColor.DARK_AQUA + " /lick <player>");
						   return true;
					}
					
					String p = sender.getName();
					Player target = Bukkit.getPlayer(args[0]);
					String cooldown = this.getConfig().getString("cooldown");
					

					if(target != null) {
						
						if(target.getName().equals("Dest5")) {
							sender.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + "You can't lick the waffle.");
							return true;
						}
						
					int cooldownTime = Integer.parseInt(cooldown);
					
					if(PF.lickCool.containsKey(sender.getName())) {
						long secondsLeft = ((PF.lickCool.get(sender.getName())/1000+cooldownTime) - System.currentTimeMillis()/1000);
						if(secondsLeft>0) {
							sender.sendMessage(ChatColor.RED + "Your toungue is still dry from the last lick, please wait.");
							return true;
						}
					}
						PF.lickCool.put(p, System.currentTimeMillis());
						
						if (target != null) {
							Bukkit.broadcastMessage(ChatColor.BLUE + p + ChatColor.RED + " l" + ChatColor.LIGHT_PURPLE + "i" + ChatColor.GOLD + "c" + ChatColor.BLUE + "k" + ChatColor.YELLOW + "e" + ChatColor.WHITE + "d " + ChatColor.BLUE + target.getName() + ChatColor.DARK_RED + "!");
							return true;
					} else {
						
						sender.sendMessage(ChatColor.RED + "Player not online.");
						return true;
						
					}
					
					
				}
				return false;
				
			}
					
				}
				
			}
		return true;
	}
			
	
	
	public String getCommand() {	
		return command;
	}
	
	
	private String getPerm() {
		return permission;
	}
	

}
