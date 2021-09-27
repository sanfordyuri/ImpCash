package br.com.impalinha.Config;

import br.com.impalinha.Main;
import org.bukkit.plugin.Plugin;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

import static br.com.impalinha.Constantes.KEYS_PATH;
import static br.com.impalinha.Constantes.PREFIXO;

public class ModificacaoConfig {

    static Plugin plugin = Main.getPlugin(Main.class);

    public static BigDecimal getValor(String codigo) {
        if (containsCodigo(codigo)) {
            String valor = plugin.getConfig().getString((KEYS_PATH + codigo + ".Valor"));
            return new BigDecimal(valor);
        }
        return new BigDecimal("0.00");
    }

    public static boolean containsCodigo(String codigo) {
        try {
            Object o = plugin.getConfig().get((KEYS_PATH + codigo));
            return o != null;
        } catch (Exception e) {
            plugin.getLogger().info(PREFIXO + "§cEsse codigo nao existe...");
            return false;
        }
    }

    public static void removerCodigo(String codigo) {
        if (containsCodigo(codigo)) {
            plugin.getConfig().set(KEYS_PATH+codigo, null);
            plugin.saveConfig();
            plugin.reloadConfig();
        } else {
            plugin.getLogger().info(PREFIXO + "§cEsse codigo nao existe...");
        }
    }

    public static void verificarKeysExpiradas() {
        for (String codigo : plugin.getConfig().getConfigurationSection(KEYS_PATH).getKeys(false)) {
            String data = plugin.getConfig().getString(KEYS_PATH + codigo + ".Data-Expira");
            LocalDateTime dateTime = LocalDateTime.parse(data);
            Duration duration = Duration.between(dateTime, LocalDateTime.now());
            if(!duration.isNegative()) {
                plugin.getConfig().set(KEYS_PATH + codigo, null);
                plugin.saveConfig();
                plugin.reloadConfig();
                plugin.getLogger().info(PREFIXO + "Key expirada e removida da config. " + duration);
            }
        }
    }


}
