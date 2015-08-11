package ladaspacequest;

import logiikka.NappaimistonKuuntelija;
import logiikka.Piirtoalusta;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import kuviot.Lada;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;

    public Kayttoliittyma() {
    }

    private void luoKomponentit(Container container) {
        Piirtoalusta piirtoalusta = new Piirtoalusta();
        container.add(piirtoalusta);
        frame.addKeyListener(new NappaimistonKuuntelija(piirtoalusta.getHahmo(), piirtoalusta));
    }

    @Override
    public void run() {
        frame = new JFrame("LadaSpaceQuest");
        frame.setPreferredSize(new Dimension(1000, 700));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);


}
}
