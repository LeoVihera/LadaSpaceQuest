package ladaspacequest;

import kuviot.Lada;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import kuviot.Ammus;

public class Piirtoalusta extends JPanel implements ActionListener {

    private Lada hahmo;
    Timer timer = new Timer(50, this);

    public Piirtoalusta(Lada hahmo) {
        super.setBackground(Color.WHITE);
        this.hahmo = hahmo;
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        hahmo.piirra(graphics);
        for (Ammus ammus : hahmo.getAmmukset()) {
            ammus.piirra(graphics);
        }
    }

    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == timer) {
            hahmo.siirry();
            for (Ammus ammus : hahmo.getAmmukset()) {
                ammus.siirry();
            }
            repaint();
        }

    }
}
