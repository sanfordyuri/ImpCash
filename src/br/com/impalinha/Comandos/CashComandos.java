package br.com.impalinha.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.impalinha.Constantes;

public class CashComandos implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String str, String[] args) {
		if(command.getName().equalsIgnoreCase("cash")) {
			Player player = (Player) sender;
			if(player.hasPermission(new Constantes().permissionAdmin)) {
				
			}
		}
		return false;
	}

}
