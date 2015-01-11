package nomarthehero.projectfun.commands;

import nomarthehero.projectfun.ProjectFun;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SlapCommand implements CommandExecutor {
	
	/*
	 * COPY THIS WHOLE CLASS INTO A NEW CLASS FOR A NEW COMMAND
	 * 
	 * Replace "String command = null" with the command, for example "String command = slap" (make sure it's lowercase)
	 * Replace "String permission = null" with the permission you set it to in the plugin.yml, for example "String permission = projectfun.command.slap" (lowercase)
	 * 
	 * Make sure to register the command in ProjectFun
	 */
	
	private String command = /hug;
	
	private String permission = projectfun.hug;
	
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
						   p1.sendMessage(ChatColor.RED + "Not enough arguments!" + ChatColor.DARK_AQUA + " /hug <player>");
						   return true;
					}
					
					else if (args.length > 1) {
							p1.sendMessage(ChatColor.RED + "Too many arguments!" + ChatColor.DARK_AQUA + " /hug <player>");
							return true;
					}
					
					String p = p1.getName();
					Player target = Bukkit.getPlayer(args[0]);
					String cooldown = getConfig().getString("cooldown-time");
					

					if(target != null || args[0].equalsIgnoreCase("all")) {
						
					int cooldownTime = Integer.parseInt(cooldown);
					
					if(cooldowns.containsKey(p1.getName())) {
						long secondsLeft = ((cooldowns.get(p1.getName())/1000+cooldownTime) - System.currentTimeMillis()/1000);
						if(secondsLeft>0) {
							p1.sendMessage(ChatColor.RED + "You can only hug one player every 100 seconds.");
							return true;
						}
					}
						cooldowns.put(p, System.currentTimeMillis());
						
						if (target != null) {
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + p + ChatColor.RED + " hugged " + ChatColor.LIGHT_PURPLE + target.getName() + ChatColor.DARK_RED + " ♥");
							}
					
						return true;
						
					} else {
						
						p1.sendMessage(ChatColor.RED + "Player not online.");
						return true;
						
					}
					
					
				}
				return false;
				
			}
					
				}
				
			}
			
			else return true;			
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