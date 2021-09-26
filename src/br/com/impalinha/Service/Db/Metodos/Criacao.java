package br.com.impalinha.Service.Db.Metodos;

import br.com.impalinha.Service.Db.Conexao;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Criacao extends Conexao {

    public static void create(Player player) {
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("INSERT INTO `ImpCash`(`Player`, `Amount`) VALUES (?,?)");
            stm.setString(1, player.getUniqueId().toString());
            stm.setDouble(2, 0.0);
            stm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
