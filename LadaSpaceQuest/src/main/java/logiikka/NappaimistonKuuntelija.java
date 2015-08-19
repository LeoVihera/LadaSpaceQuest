package logiikka;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import kuviot.Lada;
import ladaspacequest.Kayttoliittyma;

public class NappaimistonKuuntelija implements KeyListener {

    private Piirtoalusta piirtoalusta;
    private Lada hahmo;
    private JFrame frame;

    public NappaimistonKuuntelija(Lada hahmo, Piirtoalusta alusta, JFrame frame) {
        this.hahmo = hahmo;
        this.piirtoalusta = alusta;
        this.frame = frame;
    }

    /**
     * Kutsuu hahmon suuntaavaihtavaa metodia, kun painetaan a, ja
     * ampumismetodia, kun painetaan s
     *
     * @param e Painettu näppäin
     *
     * @see kuviot.Lada#hyppy()
     * @see kuviot.Lada#ammu()
     *
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            hahmo.hyppy();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hahmo.ammu();
        } else if (e.getKeyCode() == KeyEvent.VK_R) {
            if (!hahmo.isHengissa()) {
                frame.dispose();
                Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
                SwingUtilities.invokeLater(kayttoliittyma);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_T) {
            if (!hahmo.isHengissa()) {
                frame.dispose();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
