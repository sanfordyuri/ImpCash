package br.com.impalinha.Comandos.Mensagens;

import br.com.impalinha.Service.Db.Metodos.Modificacao;
import org.bukkit.entity.Player;

import static br.com.impalinha.Constantes.PREFIXO;

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

    public static void mensagemCashForAdmins(Player player) {
        player.sendMessage(" ");
        player.sendMessage("§c - Apenas para Admins  - ");
        player.sendMessage(" ");
        player.sendMessage("§f» §c Cash remove [Jogador] [Quantidade]");
        player.sendMessage("§f» §c Cash set [Jogador] [Quantidade]");
        player.sendMessage("§f» §c Cash add [Jogador] [Quantidade]");
        player.sendMessage("§f» §c Cash gerar [Quantidade] [Dias]");
        player.sendMessage(" ");
    }


    public static void mensagemVerMais(Player player) {
        player.sendMessage(PREFIXO + "§fOlá, " + player.getName() + ", vou tentar resumir para você a importância do ZoneCash");
        player.sendMessage(" ");
        player.sendMessage(" §9» §fEssa é a moeda de troca mais valiosa no servidor inteiro");
        player.sendMessage(" §9» §fSe você tem ZoneCash o suficiente pode adquirir §BVIPs");
        player.sendMessage(" §9» §fEm TODOS os eventos você terá vantagens proporcional ao seu Cash");
        player.sendMessage(" §9» §fCom Cash você pode comprar §nTicket§r §fpara Eventos Exclusivos");
        player.sendMessage("  ");
        player.sendMessage(" §9» §eEntendeu agora? não perca tempo e adquira logo, com qualquer valor!");
    }


}
