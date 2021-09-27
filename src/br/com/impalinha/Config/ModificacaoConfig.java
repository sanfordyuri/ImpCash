package br.com.impalinha.Config;

import br.com.impalinha.Main;
import org.bukkit.plugin.Plugin;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

import static br.com.impalinha.Constantes.*;

public class ModificacaoConfig {

    static final Plugin plugin = Main.getPlugin(Main.class);

    public static BigDecimal getValor(String codigo) {
        if (containsCodigo(codigo)) {
            String valor = plugin.getConfig().getString((KEYS_PATH + codigo + VALOR));
            return new BigDecimal(valor);
        }
        return BigDecimal.ZERO;
    }

    public static boolean containsCodigo(String codigo) {
        try {
            Object o = plugin.getConfig().get((KEYS_PATH + codigo));
            return o != null;
        } catch (Exception e) {
            plugin.getLogger().info(PREFIXO + MENSAGEM_CODIGO_INVALIDO);
            return false;
        }
    }

    public static void removerCodigo(String codigo) {
        if (containsCodigo(codigo)) {
            plugin.getConfig().set(KEYS_PATH+codigo, null);
            atualizaConfig();
        } else {
            plugin.getLogger().info(PREFIXO + MENSAGEM_CODIGO_INVALIDO);
        }
    }

    public static void verificarKeysExpiradas() {
        for (String codigo : plugin.getConfig().getConfigurationSection(KEYS_PATH).getKeys(false)) {
            String data = plugin.getConfig().getString(KEYS_PATH + codigo + DATA_EXPIRA);
            LocalDateTime dateTime = LocalDateTime.parse(data);
            Duration duration = Duration.between(dateTime, LocalDateTime.now());
            if(!duration.isNegative()) {
                plugin.getConfig().set(KEYS_PATH + codigo, null);
                atualizaConfig();
                plugin.getLogger().info(PREFIXO + "Key expirada e removida da config. " + duration);
            }
        }
    }

    public static void atualizaConfig() {
        plugin.saveConfig();
        plugin.reloadConfig();
    }


}
