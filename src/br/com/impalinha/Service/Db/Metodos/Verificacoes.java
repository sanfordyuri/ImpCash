package br.com.impalinha.Service.Db.Metodos;

import br.com.impalinha.Service.Db.Conexao;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static br.com.impalinha.Constantes.SELECT_ALL_QUERY;

@SuppressWarnings("LoopStatementThatDoesntLoop")
public class Verificacoes extends Conexao {

    public static boolean containsPlayer(Player player) {
        try {
            PreparedStatement stm = con.prepareStatement(SELECT_ALL_QUERY);
            stm.setString(1, player.getUniqueId().toString());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
}
