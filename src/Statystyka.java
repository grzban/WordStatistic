/**
 * Created by gb on 2016-09-28.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Statystyka {
    private String slowo;
    private char[] slowoCharTab;

    private Map<Character, Integer> slowoMapa = new HashMap<Character, Integer>();

    public Statystyka(String slowo) {
        this.slowo = slowo;
    }

    private char[] przepiszSlowoDoTablicy(){
        slowoCharTab = slowo.toCharArray();
        return slowoCharTab;
    }

    private Map<Character, Integer> porownajZnakiWSlowie(){
        for (int i = 0; i < slowoCharTab.length; i++){
            if (slowoMapa.containsKey(slowoCharTab[i])){
                int wartosc = slowoMapa.get(slowoCharTab[i]);
                slowoMapa.replace(slowoCharTab[i], wartosc+1);
            }else{
                slowoMapa.put(slowoCharTab[i], 1);
            }
        }
        return slowoMapa;
    }

    private void liczbaZnakowPowtarzalnych(){
        Set<Character> zbiorKluczy = slowoMapa.keySet();

        for (Character klucz : zbiorKluczy) {
            System.out.println(klucz + " " + slowoMapa.get(klucz));
        }
    }

    public void pokarzStatystyki(){
        System.out.println("Rozpatrywane slowo: " + slowo);
        przepiszSlowoDoTablicy();
        System.out.println("Liczba znakow w slowie: " + slowoCharTab.length);
        System.out.println("Występowanie poszczególnych znaków:");
        porownajZnakiWSlowie();
        liczbaZnakowPowtarzalnych();
        System.out.println("Liczba znaków unikalnych w słowie: " + slowoMapa.size());
    }
}
