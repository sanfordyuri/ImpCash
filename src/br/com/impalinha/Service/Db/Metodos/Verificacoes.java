package br.com.impalinha.Service.Db.Metodos;

import br.com.impalinha.Service.Db.Conexao;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Verificacoes extends Conexao {

    public static boolean containsPlayer(Player player) {
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("SELECT * FROM `ImpCash` WHERE `Player` = ?");
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
