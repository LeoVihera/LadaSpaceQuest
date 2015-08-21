package logiikka;

import kuviot.Lada;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;
import kuviot.Ammus;
import kuviot.Este;
import kuviot.Hitler;
import kuviot.Kuvio;
import ladaspacequest.GameOver;

/**
 * 
 * @author Leo
 */
public class Piirtoalusta extends JPanel implements ActionListener {

    
    private final Lada hahmo = new Lada();
    private final ArrayList<Este> esteet;
    Timer uudelleenPiirto = new Timer(50, this);
    Timer uusiEste = new Timer(1000, this);
    Random arpoja = new Random();
    GameOver loppu = new GameOver();

    
    public Piirtoalusta() {
        super.setBackground(new Color(150, 150, 230));
        boolean musiikki = false;
        this.esteet = new ArrayList<>();
        uudelleenPiirto.start();
        uusiEste.start();
    }

    /**
     * Piirtää hahmon, viholliset, ammukset ja pisteet
     *
     * @param graphics
     */
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        hahmo.piirra(graphics);
        piirraPisteet(graphics);
        piirraAmmukset(graphics);
        piirraEsteet(graphics);
        loppu.piirra(graphics);
    }

    /**
     * Siirtää kuvioita ajastimen mukaan, ja luo uusia vihollisia toisen
     * ajastimen mukaan
     *
     * @param aika ajastin
     */
    @Override
    public void actionPerformed(ActionEvent aika) {
        if (aika.getSource() == uudelleenPiirto) {
            vuoro();
        }
        if (aika.getSource() == uusiEste) {
            this.esteet.add(new Hitler(arpoja.nextInt(9)));
        }
        repaint();
    }

    /**
     * Jos hahmo on elossa, tarkistaa ammusten ja esteiden yhteentörmäykset ja
     * kutsuu siirtymismetodia
     */
    private void vuoro() {
        if (tarkastaEttaHahmoElaa()) {
            tarkastaAmmuksenOsuminenEsteisiin();
            tarkastaEsteidenTuhoutuminen();
            siirraKaikkea();
        }
    }

    /**
     * Kutsuu kuvioiden siirtymismetodeita
     *
     * @see kuviot.Kuvio#siirry()
     */
    public void siirraKaikkea() {
        hahmo.siirry();
        for (Ammus ammus : hahmo.getAmmukset()) {
            ammus.siirry();
        }
        for (Este este : this.esteet) {
            este.siirry();
        }

    }

    /**
     * Tarkastaa, että hahmo ei ole törmännyt ja että on vielä ruudulla
     *
     * @return boolean elääkö hahmo
     */
    public boolean tarkastaEttaHahmoElaa() {
        if (hahmo.getKordY() > 700 || hahmo.getKordY() < -50) {
            return peliPaattyi();
        }
        for (Este este : this.esteet) {
            if (hahmo.getRajat().intersects(este.getRajat())) {
                return peliPaattyi();
            }
        }
        return true;
    }

    /**
     * Suorittaa hahmon kuoleman jälkeiset toimenpiteet
     *
     * @return boolean false
     */
    public boolean peliPaattyi() {
        uudelleenPiirto.stop();
        hahmo.setHengissa(false);
        loppu.setPisteet(hahmo.getPisteet());
        loppu.setNakyvyys(true);
        repaint();
        return false;
    }

    /**
     * Tarkastaa ammusten osumisen esteisiin, vähentää niiden kestävyyttä ja
     * poistaa ne, jos kestävyys on nolla
     */
    public void tarkastaAmmuksenOsuminenEsteisiin() {
        ArrayList poistettavat = new ArrayList<Ammus>();
        for (Este este : this.esteet) {
            for (Ammus ammus : hahmo.getAmmukset()) {
                if (ammus.getRajat().intersects(este.getRajat())) {
                    este.menetaKestavyys();
                    poistettavat.add(ammus);
                }
            }
        }
        hahmo.getAmmukset().removeAll(poistettavat);
    }

    /**
     * Tarkista onko esteitä, joiden kestävys on nolla, poista jos on ja lisää
     * pisteitä ja vaikeutta
     */
    public void tarkastaEsteidenTuhoutuminen() {
        ArrayList poistettavat = new ArrayList<>();
        for (Este este : this.esteet) {
            if (este.getKestavyys() == 0) {
                poistettavat.add(este);
                hahmo.saaPiste();
                lisaaVaikeutta();
            }
        }
        this.esteet.removeAll(poistettavat);
    }

    /**
     * Pienentää uusien esteiden väliaikaa, jos se ei ole jo liian pieni
     */
    public void lisaaVaikeutta() {
        int aika = uusiEste.getDelay();
        if (aika > 200) {
            uusiEste.setDelay(aika - 20);
        }
    }

    /**
     * Piirtää tämänhetkiset pisteet yläkulmaan
     *
     * @param graphics
     */
    public void piirraPisteet(Graphics graphics) {
        graphics.setFont(new Font("Impact", Font.PLAIN, 24));
        graphics.setColor(Color.BLACK);
        graphics.drawString(Integer.toString(hahmo.getPisteet()), 920, 50);
    }

    /**
     * Kutsuu jokoisen ammuksen piirto() metodia
     *
     * @param graphics
     */
    private void piirraAmmukset(Graphics graphics) {
        for (Ammus ammus : hahmo.getAmmukset()) {
            ammus.piirra(graphics);
        }
    }

    /**
     * Kutsuu jokoisen esteen piirto() metodia
     *
     * @param graphics
     */
    private void piirraEsteet(Graphics graphics) {
        for (Este este : this.esteet) {
            este.piirra(graphics);
        }
    }

    public Lada getHahmo() {
        return hahmo;
    }

    public ArrayList<Este> getEsteet() {
        return esteet;
    }

}
