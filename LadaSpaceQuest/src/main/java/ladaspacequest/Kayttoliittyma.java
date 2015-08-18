package ladaspacequest;

import logiikka.NappaimistonKuuntelija;
import logiikka.Piirtoalusta;
import java.awt.Container;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import kuviot.Lada;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Piirtoalusta piirtoalusta = new Piirtoalusta();

    public Kayttoliittyma() {
    }

    private void luoKomponentit(Container container) {
        container.add(piirtoalusta);
        frame.addKeyListener(new NappaimistonKuuntelija(piirtoalusta.getHahmo(), piirtoalusta, frame));
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
