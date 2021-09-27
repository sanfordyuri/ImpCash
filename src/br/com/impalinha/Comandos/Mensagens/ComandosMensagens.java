package br.com.impalinha.Comandos.Mensagens;

import br.com.impalinha.Service.Db.Metodos.Modificacao;
import org.bukkit.entity.Player;

public class ComandosMensagens {

    public static void mensagemCashForPlayers(Player player) {
        player.sendMessage(" ");
        player.sendMessage("§e§o- §a§oLista de Comandos §e§o-");
        player.sendMessage(" ");
        player.sendMessage("§f» §e Cash enviar [Jogador] [Quantidade]");
        player.sendMessage("§f» §e Cash ativar [Codigo]");
        player.sendMessage("§f» §e Cash mostrar [Jogador]");
        player.sendMessage("§f» §e Cash ? §fVeja a importância dessa moeda no servidor.");
        player.sendMessage(" ");
        player.sendMessage("§bVocê possui §f" + Modificacao.getCash(player) + " §bZoneCash.");
    }

    private void mensagemCashForAdmins(Player player) {
        player.sendMessage(" ");
        player.sendMessage("§c - Apenas para Admins  - ");
        player.sendMessage(" ");
        player.sendMessage("§f» §c Cash remove [Jogador] [Quantidade]");
        player.sendMessage("§f» §c Cash set [Jogador] [Quantidade]");
        player.sendMessage("§f» §c Cash add [Jogador] [Quantidade]");
        player.sendMessage("§f» §c Cash gerar [Quantidade] [Dias]");
        player.sendMessage(" ");
    }

}
