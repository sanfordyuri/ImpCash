package br.com.impalinha.Service.CashKey;

import br.com.impalinha.Main;
import org.bukkit.plugin.Plugin;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static br.com.impalinha.Constantes.KEYS_PATH;


public class CashKey {

    Plugin plugin = Main.getPlugin(Main.class);
    private final String codigo;
    private final BigDecimal valor;
    private final LocalDateTime expíra;

    public CashKey(String codigo, BigDecimal valor, LocalDateTime expíra) {
        this.codigo = codigo;
        this.valor = valor;
        this.expíra = expíra;
    }

    public String getCodigo() {
        return codigo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getExpíra() {
        return expíra;
    }

    public void salvar() {
        plugin.getConfig().set(KEYS_PATH+getCodigo()+".Valor", getValor().toString());
        plugin.getConfig().set(KEYS_PATH+getCodigo()+".Data-Expira", getExpíra().toString());
        plugin.saveConfig();
        plugin.reloadConfig();
    }
}
