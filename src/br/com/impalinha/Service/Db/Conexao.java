package br.com.impalinha.Service.Db;

import br.com.impalinha.Main;
import org.bukkit.plugin.Plugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static br.com.impalinha.Constantes.*;
import static br.com.impalinha.Service.Db.Metodos.Mensagens.*;

public class Conexao {

    public static final Plugin plugin = Main.getPlugin(Main.class);
    public static Connection con = null;

    public static void open() {
        String ip = plugin.getConfig().getString(MYSQL_IP_ANDRESS);
        String user = plugin.getConfig().getString(MYSQL_USER);
        String pass = plugin.getConfig().getString(MYSQL_PASSWORD);
        try {
            con = DriverManager.getConnection(JDBC_MYSQL + ip + SQL_10440256, user, pass);
            conexaoAbertaMsg();
            createTable();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            problemaNaConexaoMsg();
        }
    }

    public static void close() {
        if(con!=null) {
            try {
                con.close();
                conexaoFechadaMsg();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                problemaAoFecharConexaoMsg();
            }
        }
    }

    public static void createTable() {
        if(con != null) {
            PreparedStatement stm;
            try {
                stm = con.prepareStatement(CREATE_TABLE_QUERY);
                stm.executeUpdate();
                plugin.getLogger().info(PREFIXO + TABELA_CARREGADA);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                plugin.getLogger().info(PREFIXO + ERRO_AO_CARREGAR_TABELA);
            }
        }
    }

}
