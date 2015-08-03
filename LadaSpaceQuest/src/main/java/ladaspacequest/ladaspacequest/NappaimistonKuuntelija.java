package ladaspacequest.ladaspacequest;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;
import kuviot.Lada;

public class NappaimistonKuuntelija implements KeyListener {

    private Component component;
    private Lada hahmo;

    public NappaimistonKuuntelija(Lada hahmo, Component component) {
        this.hahmo = hahmo;
        this.component = component;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            hahmo.hyppy();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hahmo.ammu();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            hahmo.hyppy();
        }
    }
}
