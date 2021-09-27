package br.com.impalinha.Service.Db.Metodos;

import br.com.impalinha.Service.Db.Conexao;
import org.bukkit.OfflinePlayer;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static br.com.impalinha.Constantes.*;

public class Modificacao extends Conexao {


    @SuppressWarnings("LoopStatementThatDoesntLoop")
    public static BigDecimal getCash(OfflinePlayer player) {
        PreparedStatement stm;
        try {
            stm = con.prepareStatement(QUERY_SELECT_AMOUNT);
            stm.setString(1, player.getUniqueId().toString());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new BigDecimal(String.valueOf(rs.getDouble(AMOUNT)));
            }
            return BigDecimal.ZERO;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return BigDecimal.ZERO;
        }
    }

    public static void setCash(OfflinePlayer player, BigDecimal amount) {
        PreparedStatement stm;
        try {
            stm = con.prepareStatement(UPDATE_AMOUNT_QUERY);
            stm.setDouble(1, Double.parseDouble(amount.toString()));
            stm.setString(2, player.getUniqueId().toString());
            stm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
