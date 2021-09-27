package br.com.impalinha.Service.Db.Metodos;

import br.com.impalinha.Main;
import br.com.impalinha.Service.Db.Conexao;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static br.com.impalinha.Constantes.ERRO_CRIAR_JOGADOR;
import static br.com.impalinha.Constantes.INSERT_QUERY;

public class Criacao extends Conexao {



    public static void create(Player player) {
        PreparedStatement stm;
        try {
            stm = con.prepareStatement(INSERT_QUERY);
            stm.setString(1, player.getUniqueId().toString());
            stm.setDouble(2, 0.0);
            stm.executeUpdate();
        } catch (SQLException throwables) {
            Plugin pl = Main.getPlugin(Main.class);
            pl.getLogger().info(ERRO_CRIAR_JOGADOR);
            throwables.printStackTrace();
        }
    }

}
