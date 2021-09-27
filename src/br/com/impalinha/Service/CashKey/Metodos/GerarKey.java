package br.com.impalinha.Service.CashKey.Metodos;

import java.util.Random;

import static br.com.impalinha.Constantes.LETRAS;
import static br.com.impalinha.Constantes.NUMEROS;

public class GerarKey {

    public static String gerarKey() {
        Random r = new Random();
        StringBuilder key = new StringBuilder();
        for(int i=0;i<=11;i++) {
            int ra = r.nextInt(100);
            if(ra <= 30) {
                key.append(NUMEROS[r.nextInt(NUMEROS.length - 1)]);
            } else if (ra <= 50) {
                key.append(LETRAS[r.nextInt(LETRAS.length - 1)]);
            } else if (ra <= 70) {
                key.append(LETRAS[r.nextInt(LETRAS.length - 1)].toUpperCase());
            } else {
                key.append(LETRAS[r.nextInt(LETRAS.length - 1)].toUpperCase());
            }
        }
        return key.toString();
    }

}
