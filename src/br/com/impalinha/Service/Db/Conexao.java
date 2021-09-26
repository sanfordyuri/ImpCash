package br.com.impalinha.Service.Db;

import br.com.impalinha.Main;
import org.bukkit.plugin.Plugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static br.com.impalinha.Constantes.PREFIXO;

public class Conexao {

    public static Plugin plugin = Main.getPlugin(Main.class);
    public static Connection con = null;

    public static void open() {
        String ip = plugin.getConfig().getString("Mysql.ip-andress");
        String user = plugin.getConfig().getString("Mysql.user");
        String pass = plugin.getConfig().getString("Mysql.password");
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/sql10440256", user, pass);
            plugin.getLogger().info("------------------------------------");
            plugin.getLogger().info(PREFIXO + "§aAberta com sucesso a conexão Mysql");
            plugin.getLogger().info("------------------------------------");
            createTable();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            plugin.getLogger().info("-----------------------------------------------------------");
            plugin.getLogger().info(PREFIXO + "§cTivemos um problema ao tentar realizar a conexão Mysql");
            plugin.getLogger().info("-----------------------------------------------------------");
        }
    }

    public static void close() {
        if(con!=null) {
            try {
                con.close();
                plugin.getLogger().info("------------------------------------");
                plugin.getLogger().info(PREFIXO + "§aConexão Mysql fechada com sucesso");
                plugin.getLogger().info("------------------------------------");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                plugin.getLogger().info("-----------------------------------------------------------");
                plugin.getLogger().info(PREFIXO + "§cTivemos um problema ao tentar fechar a conexão Mysql");
                plugin.getLogger().info("-----------------------------------------------------------");
            }
        }
    }

    public static void createTable() {
        if(con != null) {
            PreparedStatement stm = null;
            String sql = "CREATE TABLE IF NOT EXISTS `ImpCash`(`Player` VARCHAR(64), `Amount` DOUBLE)";
            try {
                stm = con.prepareStatement(sql);
                stm.executeUpdate();
                plugin.getLogger().info(PREFIXO + "§aTabela carregada com sucesso.");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                plugin.getLogger().info(PREFIXO + "§cErro ao carregar tabela.");
            }
        }
    }

}
