package br.com.impalinha.Comandos.Metodos;

import br.com.impalinha.Service.Db.Metodos.Modificacao;
import org.bukkit.OfflinePlayer;

import java.math.BigDecimal;

public class ComandosModificacao {

    public static void addCash(OfflinePlayer player, BigDecimal amout) {
        Modificacao.setCash(player, Modificacao.getCash(player).add(amout));
    }

    public static void removeCash(OfflinePlayer player, BigDecimal amout) {
        BigDecimal novo_saldo = Modificacao.getCash(player).subtract(amout);
        if (novo_saldo.compareTo(BigDecimal.ZERO) < 0) {
            Modificacao.setCash(player, BigDecimal.ZERO);
        } else {
            Modificacao.setCash(player, novo_saldo);
        }
    }

}
