package logiikka;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import kuviot.Lada;
import ladaspacequest.Kayttoliittyma;
import ladaspacequest.Ennatys;

public class NappaimistonKuuntelija implements KeyListener {

    private Piirtoalusta piirtoalusta;
    private Lada hahmo;
    private JFrame frame;
    private Ennatys ennatys;

    public NappaimistonKuuntelija(JFrame frame, Piirtoalusta piirtoalusta, Ennatys ennatys) {
        this.frame = frame;
        this.piirtoalusta = piirtoalusta;
        this.hahmo = piirtoalusta.getHahmo();
        this.ennatys = ennatys;
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
                Kayttoliittyma kayttoliittyma = new Kayttoliittyma(ennatys);
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
