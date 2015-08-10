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
    private final ArrayList<Seina> seinat;
    Timer uudelleenPiirto = new Timer(50, this);
    Timer uusiSeina = new Timer(1500, this);
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
         //   tarkastaEttaHahmoElaa();
            tarkastaAmmustenolemassaOlo();
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

    public void tarkastaEttaHahmoElaa() {
        if (hahmo.getKordY() > 700) {
            uudelleenPiirto.stop();
        }
        for (Seina seina : this.seinat) {
            if (hahmo.getRajat().intersects(seina.getRajat())) {
                uudelleenPiirto.stop();
            }
        }
    }

    public void tarkastaAmmustenolemassaOlo() {
        ArrayList poistettavat = new ArrayList<Ammus>();
        for (Seina seina : this.seinat) {
            for (Ammus ammus : hahmo.getAmmukset()) {
                if (ammus.getRajat().intersects(seina.getRajat())) {
                    poistettavat.add(ammus);
                }
            }
        }
        hahmo.getAmmukset().removeAll(poistettavat);
    }

}
