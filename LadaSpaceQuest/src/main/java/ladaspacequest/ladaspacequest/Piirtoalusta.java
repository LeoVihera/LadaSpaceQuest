package ladaspacequest.ladaspacequest;

import kuviot.Lada;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

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
    }


    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == timer) {
            hahmo.siirry();
            repaint();// this will call at every 1 second
        }

    }
}
