package word.statistic.mvc;

import javax.swing.*;
import java.awt.*;

/**
 * Created by gb on 2016-10-05.
 */
public class Widok extends JFrame {

    private JLabel wynikL;
    private JTextField slowoTF;
    private JTextArea slowoTA;
    private JButton obliczB;

    public Widok(){
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        setTitle("Word Statistics v. 2.00");

        add(panel());
        revalidate();
    }

    private JPanel panel(){

        JPanel p = new JPanel();

        p.setLayout(null);
        p.setLayout(new GridLayout(3,1));
        wynikL = new JLabel();

        slowoTA = new JTextArea();
        slowoTF = new JTextField();
        obliczB = new JButton("Pokaz statystyki");

        JScrollPane sp = new JScrollPane(slowoTA);

        p.add(sp);
        p.add(slowoTF);
        p.add(obliczB);
        return p;
    }

    public JLabel getWynikL() {
        return wynikL;
    }

    public void setWynikL(JLabel wynikL) {
        this.wynikL = wynikL;
    }

    public JTextField getSlowoTF() {
        return slowoTF;
    }

    public void setSlowoTF(JTextField slowoTF) {
        this.slowoTF = slowoTF;
    }

    public JTextArea getSlowoTA() {
        return slowoTA;
    }

    public void setSlowoTA(JTextArea slowoTA) {
        this.slowoTA = slowoTA;
    }

    public JButton getObliczB() {
        return obliczB;
    }

    public void setObliczB(JButton obliczB) {
        this.obliczB = obliczB;
    }
}
