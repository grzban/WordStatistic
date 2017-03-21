import word.statistic.mvc.Kontroler;
import word.statistic.mvc.Model;
import word.statistic.mvc.Widok;

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
