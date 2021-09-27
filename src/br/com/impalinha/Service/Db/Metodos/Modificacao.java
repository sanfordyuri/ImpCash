package br.com.impalinha.Service.Db.Metodos;

import br.com.impalinha.Service.Db.Conexao;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Modificacao extends Conexao {

    public static BigDecimal getCash(OfflinePlayer player) {
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("SELECT `Amount` FROM `ImpCash` WHERE `Player` = ?");
            stm.setString(1, player.getUniqueId().toString());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new BigDecimal(String.valueOf(rs.getDouble("Amount")));
            }
            return new BigDecimal("0.00");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return new BigDecimal("0.00");
        }
    }

    public static void setCash(OfflinePlayer player, BigDecimal amount) {
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("UPDATE `ImpCash` SET `Amount` = ? WHERE `Player` = ?");
            stm.setDouble(1, Double.parseDouble(amount.toString()));
            stm.setString(2, player.getUniqueId().toString());
            stm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
