package br.com.impalinha;

import br.com.impalinha.Comandos.CashComandos;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		LoadConfig();
		getCommand("cash").setExecutor(new CashComandos());
		getLogger().info("§aO plugin foi iniciado com sucesso.");
	}
	
	@Override
	public void onDisable() {
		getLogger().info("§cO plugin foi terminado com sucesso.");
	}

	public void LoadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

}
