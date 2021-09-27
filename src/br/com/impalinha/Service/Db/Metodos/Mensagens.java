package br.com.impalinha.Service.Db.Metodos;

import br.com.impalinha.Main;
import org.bukkit.plugin.Plugin;

import static br.com.impalinha.Constantes.PREFIXO;

public class Mensagens {

    public static final Plugin plugin = Main.getPlugin(Main.class);


    public static void problemaAoFecharConexaoMsg() {
        plugin.getLogger().info("-----------------------------------------------------------");
        plugin.getLogger().info(PREFIXO + "§cTivemos um problema ao tentar fechar a conexão Mysql");
        plugin.getLogger().info("-----------------------------------------------------------");
    }

    public static void conexaoFechadaMsg() {
        plugin.getLogger().info("------------------------------------");
        plugin.getLogger().info(PREFIXO + "§aConexão Mysql fechada com sucesso");
        plugin.getLogger().info("------------------------------------");
    }


    public static void problemaNaConexaoMsg() {
        plugin.getLogger().info("-----------------------------------------------------------");
        plugin.getLogger().info(PREFIXO + "§cTivemos um problema ao tentar realizar a conexão Mysql");
        plugin.getLogger().info("-----------------------------------------------------------");
    }

    public static void conexaoAbertaMsg() {
        plugin.getLogger().info("------------------------------------");
        plugin.getLogger().info(PREFIXO + "§aAberta com sucesso a conexão Mysql");
        plugin.getLogger().info("------------------------------------");
    }
}
