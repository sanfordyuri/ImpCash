package br.com.impalinha.Comandos.Metodos;

import br.com.impalinha.Service.Db.Metodos.Modificacao;
import org.bukkit.entity.Player;

import java.math.BigDecimal;

public class ComandosModificacao {

    public static void addCash(Player player, BigDecimal amout) {
        Modificacao.setCash(player, Modificacao.getCash(player).add(amout));
    }

    public static void removeCash(Player player, BigDecimal amout) {
        BigDecimal novo_saldo = Modificacao.getCash(player).subtract(amout);
        if (novo_saldo.compareTo(new BigDecimal("0.0")) < 0) {
            Modificacao.setCash(player, new BigDecimal("0.0"));
        } else {
            Modificacao.setCash(player, novo_saldo);
        }
    }

}
