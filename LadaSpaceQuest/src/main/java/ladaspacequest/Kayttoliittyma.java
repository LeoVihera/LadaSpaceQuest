package ladaspacequest.ladaspacequest;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import kuviot.Lada;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Lada hahmo;

    public Kayttoliittyma() {
        this.hahmo = new Lada();
    }

    private void luoKomponentit(Container container) {
        Piirtoalusta piirtoalusta = new Piirtoalusta(hahmo);
        container.add(piirtoalusta);

        frame.addKeyListener(new NappaimistonKuuntelija(hahmo, piirtoalusta));
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
