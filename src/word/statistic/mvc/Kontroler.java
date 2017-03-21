package word.statistic.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Kontroler {

    private Model model;
    private Widok widok;
    private char[] slowoCharTab;
    private Map<Character, Integer> slowoMapa = new HashMap<Character, Integer>();

    private String slowo;

    public Kontroler(Model model, Widok widok) {
        this.model = model;
        this.widok = widok;
    }

    public void obsluzPrzycisk(){
        widok.getObliczB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ustawWarunkiPoczatkowe();
                pobierzSlowo();
                przepiszSlowoDoTablicy();
                porownajZnakiWSlowie();
                liczbaZnakowPowtarzalnych();
                //pokarzStatystyki();
                ustawWynikWLabel();
            }
        });
    }
    private void ustawWarunkiPoczatkowe(){
        slowo = "";
        slowoMapa.clear();
    }

    private void pobierzSlowo(){
        slowo = widok.getSlowoTF().getText();
        model.setSlowo(slowo);
    }

    private char[] przepiszSlowoDoTablicy(){
        slowoCharTab = model.getSlowo().toCharArray();
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

    private String liczbaZnakowPowtarzalnych(){
        Set<Character> zbiorKluczy = slowoMapa.keySet();
        String wynik = "";
        for (Character klucz : zbiorKluczy) {
            wynik += klucz + " " + slowoMapa.get(klucz) +"\n";
        }
        return wynik;
    }

    private void pokarzStatystyki(){
        System.out.println("Rozpatrywane slowo: " + model.getSlowo());
        przepiszSlowoDoTablicy();
        System.out.println("Liczba znakow w slowie: " + slowoCharTab.length);
        System.out.println("Występowanie poszczególnych znaków:");
        porownajZnakiWSlowie();
        liczbaZnakowPowtarzalnych();
        System.out.println("Liczba znaków unikalnych w słowie: " + slowoMapa.size());
    }

    private void ustawWynikWLabel(){
        String wynik ="";

        wynik += "Rozpatrywane slowo: " + model.getSlowo() + "\n";
        wynik += "Liczba znakow w slowie: " + slowoCharTab.length + "\n";
        wynik += "Występowanie poszczególnych znaków: \n";
        wynik += liczbaZnakowPowtarzalnych();
        wynik += "Liczba znaków unikalnych w słowie: " + slowoMapa.size() + "\n";

        widok.getSlowoTA().setText(wynik);
    }
}
