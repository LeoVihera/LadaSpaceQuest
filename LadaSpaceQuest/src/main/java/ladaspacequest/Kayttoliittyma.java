package ladaspacequest;

import logiikka.NappaimistonKuuntelija;
import logiikka.Piirtoalusta;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Ennatys ennatys;
    private Piirtoalusta piirtoalusta;
    

    public Kayttoliittyma(Ennatys ennatys) {
         this.piirtoalusta = new Piirtoalusta(ennatys);
         this.ennatys = ennatys;
    }

    private void luoKomponentit(Container container) {
        container.add(piirtoalusta);
        frame.addKeyListener(new NappaimistonKuuntelija(frame, piirtoalusta, ennatys));
    }

    @Override
    public void run() {
        frame = new JFrame("LadaSpaceQuest");
        frame.setPreferredSize(new Dimension(1000, 700));
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

}
