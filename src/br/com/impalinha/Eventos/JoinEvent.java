package br.com.impalinha.Eventos;

import br.com.impalinha.Service.Db.Metodos.Criacao;
import br.com.impalinha.Service.Db.Metodos.Verificacoes;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    @EventHandler
    public void onFirstJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(!Verificacoes.containsPlayer(p)) {
            Criacao.create(p);
        }
    }

}
