package br.com.impalinha.Comandos;

import br.com.impalinha.Comandos.Metodos.ComandosModificacao;
import br.com.impalinha.Config.ModificacaoConfig;
import br.com.impalinha.Service.CashKey.CashKey;
import br.com.impalinha.Service.CashKey.Metodos.GerarKey;
import br.com.impalinha.Service.Db.Metodos.Modificacao;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static br.com.impalinha.Constantes.*;

public class CashComandos implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String str, String[] args) {
		if(command.getName().equalsIgnoreCase(COMMAND_NAME)) {
			Player player = (Player) sender;
			if (args.length == 0) {
				player.sendMessage(" ");
				player.sendMessage("§e§o- §a§oLista de Comandos §e§o-");
				player.sendMessage(" ");
				player.sendMessage("§f» §e Cash enviar [Jogador] [Quantidade]");
				player.sendMessage("§f» §e Cash ativar [Codigo]");
				player.sendMessage("§f» §e Cash mostrar [Jogador]");
				player.sendMessage("§f» §e Cash ? §fVeja a importância dessa moeda no servidor.");
				player.sendMessage(" ");
				player.sendMessage("§bVocê possui §f" + Modificacao.getCash(player) + " §bZoneCash.");
				if(player.hasPermission(PERMISSION_ADMIN)) {
					player.sendMessage(" ");
					player.sendMessage("§c - Apenas para Admins  - ");
					player.sendMessage(" ");
					player.sendMessage("§f» §c Cash remove [Jogador] [Quantidade]");
					player.sendMessage("§f» §c Cash set [Jogador] [Quantidade]");
					player.sendMessage("§f» §c Cash add [Jogador] [Quantidade]");
					player.sendMessage("§f» §c Cash gerar [Quantidade] [Dias]");
					player.sendMessage(" ");
				}
			} else {
				if (args[0].equalsIgnoreCase("mostrar")) {
					if (args.length == 2) {
						Player alvo = Bukkit.getPlayer(args[1]);
						player.sendMessage(PREFIXO+"§f" + alvo.getName() + " §apossui " + Modificacao.getCash(alvo) + " ZoneCash.");
					} else {
						player.sendMessage("§cUse o formato correto! Ex:. /cash mostrar [Jogador]");
					}
				} else if(args[0].equalsIgnoreCase("ativar")) {
					if (args.length == 2) {
						String codigo = args[1];
						if(ModificacaoConfig.containsCodigo(codigo)) {
							BigDecimal valor = ModificacaoConfig.getValor(codigo);
							ComandosModificacao.addCash(player, valor);
							player.sendMessage(PREFIXO + "§aZoneCash ativado com sucesso.");
							player.sendMessage("§bO seu novo saldo é de " + Modificacao.getCash(player) + " ZoneCash.");
							ModificacaoConfig.removerCodigo(codigo);
						} else {
							player.sendMessage(PREFIXO + "§cEsse código é invalido.");
						}
					} else {
						player.sendMessage(PREFIXO + "§cUso correto: /cash ativar [Codigo]");
					}
				} else if (args[0].equalsIgnoreCase("enviar")) {
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
								player.sendMessage(PREFIXO + "§cVocê nao possui saldo o suficiente.");
							}
						} catch (Exception e) {
							player.sendMessage("§cUse o formato correto! Ex:. /cash enviar HadyMan 250");
						}
					} else {
						player.sendMessage("§cUse o formato correto! Ex:. /cash enviar HadyMan 250");
					}
				}
				if (player.hasPermission(PERMISSION_ADMIN)) {
					if (args[0].equalsIgnoreCase("gerar")) {
						if (args.length == 3) {
							try {
								BigDecimal valor = new BigDecimal(args[1]);
								int dias = Integer.parseInt(args[2]);
								final LocalDateTime date = LocalDateTime.now();
								CashKey cashKey = new CashKey(GerarKey.gerarKey(), valor, date.plusDays(dias));
								cashKey.salvar();
								player.sendMessage("§aVocê gerou uma nova Key: §b" + cashKey.getCodigo());
								player.sendMessage("§cEssa key irá se expirar em: " + date.plusDays(dias));
							} catch (Exception e) {
								player.sendMessage("§cUse o formato correto! Ex:. /cash gerar 250.00 15");
								e.printStackTrace();
							}
						} else {
							player.sendMessage("§cUso correto: /cash gerar [Quantidade] [Dias]");
						}
					} else if (args[0].equalsIgnoreCase("set")) {
						if (args.length == 3) {
							try {
								Player alvo = Bukkit.getPlayer(args[1]);
								BigDecimal amount = new BigDecimal(args[2]);
								Modificacao.setCash(alvo, amount);
								alvo.sendMessage(PREFIXO + "§aForças maiores definiram seu saldo para §b" + Modificacao.getCash(player) + " ZoneCash");
								player.sendMessage(PREFIXO + "§aSaldo enviado com sucesso para §f" +alvo.getName());
							} catch (Exception e) {
								player.sendMessage("§cUse o formato correto! Ex:. /cash set [Jogador] [Quantidade]");
								e.printStackTrace();
							}
						} else {
							player.sendMessage("§cUse o formato correto! Ex:. /cash set [Jogador] [Quantidade]");
						}
					} else if (args[0].equalsIgnoreCase("remove")) {
						if (args.length == 3) {
							try {
								Player alvo = Bukkit.getPlayer(args[1]);
								BigDecimal amount = new BigDecimal(args[2]);
								ComandosModificacao.removeCash(alvo, amount);
								player.sendMessage(PREFIXO + "§aSaldo removido com sucesso para §f" +alvo.getName());
							} catch (Exception e) {
								player.sendMessage("§cUse o formato correto! Ex:. /cash remove [Jogador] [Quantidade]");
								e.printStackTrace();
							}
						} else {
							player.sendMessage("§cUse o formato correto! Ex:. /cash remove [Jogador] [Quantidade]");
						}
					} else if (args[0].equalsIgnoreCase("add")) {
						if (args.length == 3) {
							try {
								Player alvo = Bukkit.getPlayer(args[1]);
								BigDecimal amount = new BigDecimal(args[2]);
								ComandosModificacao.addCash(alvo, amount);
								player.sendMessage(PREFIXO + "§aSaldo adicionado com sucesso para §f" +alvo.getName());
								alvo.sendMessage(PREFIXO + "§aForças maiores enviaram §b" + amount + " ZoneCash §apara você.");
							} catch (Exception e) {
								player.sendMessage("§cUse o formato correto! Ex:. /cash add [Jogador] [Quantidade]");
								e.printStackTrace();
							}
						} else {
							player.sendMessage("§cUse o formato correto! Ex:. /cash add [Jogador] [Quantidade]");
						}
					}
				}
			}
		}
		return false;
	}

}
