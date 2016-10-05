package word.statistic.mvc;

/**
 * Created by gb on 2016-10-05.
 */
public class RunWordStatistic {

    public static void main(String[] args) {
        Model model = new Model();
        Widok widok = new Widok();
        Kontroler kontroler = new Kontroler(model, widok);
        kontroler.obsluzPrzycisk();
    }
}
