package br.com.impalinha;

import br.com.impalinha.Comandos.CashComandos;
import br.com.impalinha.Eventos.JoinEvent;
import br.com.impalinha.Service.Db.Conexao;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		Conexao.open();
		LoadConfig();
		Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
		getCommand("cash").setExecutor(new CashComandos());
		getLogger().info("§aO plugin foi iniciado com sucesso.");
	}
	
	@Override
	public void onDisable() {
		Conexao.close();
		getLogger().info("§cO plugin foi terminado com sucesso.");
	}

	public void LoadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

}
