package br.com.impalinha.Service.CashKey.Metodos;

import java.util.Random;

public class GerarKey {

    public static String gerarKey() {
        Random r = new Random();
        String key = "";
        String[] letras = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","y","x","z"};
        int[] numeros = {0,1,2,3,4,5,6,7,8,9};
        for(int i=0;i<=11;i++) {
            int ra = r.nextInt(100);
            if(ra <= 30) {
                key += numeros[r.nextInt(numeros.length-1)];
            } else if( ra <= 50) {
                key += letras[r.nextInt(letras.length-1)];
            } else if(ra <= 70) {
                key += letras[r.nextInt(letras.length-1)].toUpperCase();
            } else if(ra<=100) {
                key += letras[r.nextInt(letras.length-1)].toUpperCase();
            }
        }
        return key;
    }

}
