package br.com.impalinha;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getLogger().info("§aO plugin foi iniciado com sucesso.");
	}
	
	@Override
	public void onDisable() {
		getLogger().info("§cO plugin foi terminado com sucesso.");
	}

}
