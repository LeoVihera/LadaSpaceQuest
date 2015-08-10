package ladaspacequest;

import kuviot.Lada;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;
import kuviot.Ammus;
import kuviot.Seina;

public class Piirtoalusta extends JPanel implements ActionListener {

    private final Lada hahmo;
    private ArrayList<Seina> seinat;
    Timer uudelleenPiirto = new Timer(50, this);
    Timer uusiSeina = new Timer(1000, this);
    Random arpoja = new Random();


    public Piirtoalusta(Lada hahmo) {
        super.setBackground(Color.WHITE);
        this.hahmo = hahmo;
        this.seinat = new ArrayList<>();
        uudelleenPiirto.start();
        uusiSeina.start();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        hahmo.piirra(graphics);
        for (Ammus ammus : hahmo.getAmmukset()) {
            ammus.piirra(graphics);
        }
        for (Seina seina : this.seinat) {
            seina.piirra(graphics);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == uudelleenPiirto) {
            siirraKaikkea();
        }
        if (ev.getSource() == uusiSeina) {
            this.seinat.add(new Seina(arpoja.nextInt(4)));
        }
        repaint();
    }

    public void siirraKaikkea() {
        hahmo.siirry();
        for (Ammus ammus : hahmo.getAmmukset()) {
            ammus.siirry();
        }
        for (Seina seina : this.seinat) {
            seina.siirry();
        }

    }

}
