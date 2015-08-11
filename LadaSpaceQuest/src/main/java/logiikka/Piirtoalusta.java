package logiikka;

import kuviot.Lada;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;
import javax.swing.Timer;
import kuviot.Ammus;
import kuviot.Este;
import kuviot.Hitler;

public class Piirtoalusta extends JPanel implements ActionListener {

    private final Lada hahmo = new Lada();
    private final ArrayList<Este> esteet;
    Timer uudelleenPiirto = new Timer(50, this);
    Timer uusiSeina = new Timer(1000, this);
    Random arpoja = new Random();

    public Piirtoalusta() {
        super.setBackground(Color.WHITE);
        this.esteet = new ArrayList<>();
        uudelleenPiirto.start();
        uusiSeina.start();
        aloitaMusiikki();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        hahmo.piirra(graphics);
        for (Ammus ammus : hahmo.getAmmukset()) {
            ammus.piirra(graphics);
        }
        for (Este este : this.esteet) {
            este.piirra(graphics);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == uudelleenPiirto) {
            tarkastaEttaHahmoElaa();
            tarkastaAmmustenolemassaOlo();
            siirraKaikkea();
        }
        if (ev.getSource() == uusiSeina) {
            this.esteet.add(new Hitler(arpoja.nextInt(10)));
        }
        repaint();
    }

    public void siirraKaikkea() {
        hahmo.siirry();
        for (Ammus ammus : hahmo.getAmmukset()) {
            ammus.siirry();
        }
        for (Este este : this.esteet) {
            este.siirry();
        }

    }

    public void tarkastaEttaHahmoElaa() {
        if (hahmo.getKordY() > 700) {
            uudelleenPiirto.stop();
        }
        for (Este este : this.esteet) {
            if (hahmo.getRajat().intersects(este.getRajat())) {
                uudelleenPiirto.stop();
            }
        }
    }

    public void tarkastaAmmustenolemassaOlo() {
        ArrayList poistettavat = new ArrayList<Ammus>();
        for (Este este : this.esteet) {
            for (Ammus ammus : hahmo.getAmmukset()) {
                if (ammus.getRajat().intersects(este.getRajat())) {
                    poistettavat.add(ammus);
                }
            }
        }
        hahmo.getAmmukset().removeAll(poistettavat);
    }

    public void aloitaMusiikki() {
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("musiikki.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException uae) {
            System.out.println(uae);
        }
    }

    public Lada getHahmo() {
        return hahmo;
    }
    
}
