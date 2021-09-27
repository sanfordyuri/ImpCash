package br.com.impalinha.Comandos;

import br.com.impalinha.Comandos.Metodos.ComandosModificacao;
import br.com.impalinha.Config.ModificacaoConfig;
import br.com.impalinha.Service.CashKey.CashKey;
import br.com.impalinha.Service.CashKey.Metodos.GerarKey;
import br.com.impalinha.Service.Db.Metodos.Modificacao;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static br.com.impalinha.Comandos.Mensagens.ComandosMensagens.*;
import static br.com.impalinha.Constantes.*;

public class CashComandos implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String str, String[] args) {
		if(command.getName().equalsIgnoreCase(COMMAND_NAME)) {
			Player player = (Player) sender;
			if (args.length == 0) {
				mensagemCashForPlayers(player);
				if(player.hasPermission(PERMISSION_ADMIN)) {
					mensagemCashForAdmins(player);
				}
			} else {
				if (args[0].equalsIgnoreCase(COMANDO_VERMAIS)) {
					if (args.length == 1) {
						mensagemVerMais(player);
					}
				} else if (args[0].equalsIgnoreCase(COMANDO_MOSTRARCASH)) {
					if (args.length == 2) {
						OfflinePlayer alvo = Bukkit.getOfflinePlayer(args[1]);
						player.sendMessage(PREFIXO+"§f" + alvo.getName() + " §apossui " + Modificacao.getCash(alvo) + " ZoneCash.");
					} else {
						player.sendMessage(MENSAGEM_USO_CORRETO_MOSTRAR);
					}
				} else if(args[0].equalsIgnoreCase(COMANDO_ATIVAR)) {
					if (args.length == 2) {
						String codigo = args[1];
						if(ModificacaoConfig.containsCodigo(codigo)) {
							BigDecimal valor = ModificacaoConfig.getValor(codigo);
							ComandosModificacao.addCash(player, valor);
							player.sendMessage(PREFIXO + MENSAGEM_ZONECASH_ATIVADO);
							player.sendMessage("§bO seu novo saldo é de " + Modificacao.getCash(player) + " ZoneCash.");
							ModificacaoConfig.removerCodigo(codigo);
						} else {
							player.sendMessage(PREFIXO + MENSAGEM_CODIGO_INVALIDO);
						}
					} else {
						player.sendMessage(PREFIXO + MENSAGEM_USO_CORRETO_ATIVAR);
					}
				} else if (args[0].equalsIgnoreCase(COMANDOS_ENVIAR)) {
					if (args.length == 3) {
						try {
							Player alvo = Bukkit.getPlayer(args[1]);
							BigDecimal quantia = new BigDecimal(args[2]);
							if(Modificacao.getCash(player).compareTo(quantia) >= 0) {
								ComandosModificacao.removeCash(player, quantia);
								ComandosModificacao.addCash(alvo, quantia);
								player.sendMessage(PREFIXO + "§aVocê enviou §b" + quantia + " ZoneCash §apara " + alvo.getName());
								alvo.sendMessage(PREFIXO + player.getName() + "§aenviou §b" + quantia + " ZoneCash §apara você.");
							} else {
								player.sendMessage(PREFIXO + MENSAGEM_NAO_POSSUI_SALDO);
							}
						} catch (Exception e) {
							player.sendMessage(USO_CORRETO_ENVIAR);
						}
					} else {
						player.sendMessage(USO_CORRETO_ENVIAR);
					}
				}
				if (player.hasPermission(PERMISSION_ADMIN)) {
					if (args[0].equalsIgnoreCase(COMANDO_GERAR)) {
						if (args.length == 3) {
							try {
								BigDecimal valor = new BigDecimal(args[1]);
								int dias = Integer.parseInt(args[2]);
								final LocalDateTime date = LocalDateTime.now();
								CashKey cashKey = new CashKey(GerarKey.gerarKey(), valor, date.plusDays(dias));
								cashKey.salvar();
								player.sendMessage("§aVocê gerou uma nova Key: §b" + cashKey.getCodigo());
								player.sendMessage("§cEssa key irá se expirar em (Horario do servidor): " + date.plusDays(dias));
							} catch (Exception e) {
								player.sendMessage(MENSAGEM_USO_CORRETO_GERAR);
								e.printStackTrace();
							}
						} else {
							player.sendMessage(MENSAGEM_USO_CORRETO_GERAR);
						}
					} else if (args[0].equalsIgnoreCase(COMANDO_SET)) {
						if (args.length == 3) {
							try {
								Player alvo = Bukkit.getPlayer(args[1]);
								BigDecimal amount = new BigDecimal(args[2]);
								Modificacao.setCash(alvo, amount);
								alvo.sendMessage(PREFIXO + "§aForças maiores definiram seu saldo para §b" + Modificacao.getCash(player) + " ZoneCash");
								player.sendMessage(PREFIXO + "§aSaldo enviado com sucesso para §f" +alvo.getName());
							} catch (Exception e) {
								player.sendMessage(MENSAGEM_USO_CORRETO_SET);
								e.printStackTrace();
							}
						} else {
							player.sendMessage(MENSAGEM_USO_CORRETO_SET);
						}
					} else if (args[0].equalsIgnoreCase(COMANDO_REMOVE)) {
						if (args.length == 3) {
							try {
								Player alvo = Bukkit.getPlayer(args[1]);
								BigDecimal amount = new BigDecimal(args[2]);
								ComandosModificacao.removeCash(alvo, amount);
								player.sendMessage(PREFIXO + "§aSaldo removido com sucesso para §f" +alvo.getName());
							} catch (Exception e) {
								player.sendMessage(MENSAGEM_USO_CORRETO_REMOVE);
								e.printStackTrace();
							}
						} else {
							player.sendMessage(MENSAGEM_USO_CORRETO_REMOVE);
						}
					} else if (args[0].equalsIgnoreCase(COMANDO_ADD)) {
						if (args.length == 3) {
							try {
								Player alvo = Bukkit.getPlayer(args[1]);
								BigDecimal amount = new BigDecimal(args[2]);
								ComandosModificacao.addCash(alvo, amount);
								player.sendMessage(PREFIXO + "§aSaldo adicionado com sucesso para §f" +alvo.getName());
								alvo.sendMessage(PREFIXO + "§aForças maiores enviaram §b" + amount + " ZoneCash §apara você.");
							} catch (Exception e) {
								player.sendMessage(MENSAGEM_USO_CORRETO_ADD);
								e.printStackTrace();
							}
						} else {
							player.sendMessage(MENSAGEM_USO_CORRETO_ADD);
						}
					}
				}
			}
		}
		return false;
	}


}
