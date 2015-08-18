package kuviot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * Luokka joka sisältää pelihahmon metodit
 *
 * @author Leo
 */
public class Lada extends Kuvio {

    private int suunta;
    private int pisteet;
    private ArrayList<Ammus> ammukset;
    private boolean hengissa;

    public Lada() {
        super(100, 350);
        this.suunta = 1;
        this.ammukset = new ArrayList<Ammus>();
        this.pisteet = 0;
        this.hengissa = true;
    }

    /**
     * Metodi, joka siirtää hahmoa, ja samalla kiihdttää sitä
     */
    @Override
    public void siirry() {
        this.kordY = this.kordY + suunta;
        this.suunta = this.suunta + 2;
    }

    /**
     * Metodi, joka vaihtaa ladan suuntaa
     */
    public void hyppy() {
        this.suunta = -25;
    }

    /**
     * Metodi, joka lisää ladan ammusluotteloon ja siten myös peliin uuden
     * ammuksen
     */
    public void ammu() {
        this.ammukset.add(new Ammus(this.kordX + 30, this.kordY));
    }

    /**
     * Metodi, joka piirtää hahmon
     *
     * @param graphics
     */
    @Override
    public void piirra(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillRect(kordX, kordY, 50, 20);
        graphics.fillRect(kordX + 10, kordY - 10, 30, 10);
        graphics.setColor(Color.DARK_GRAY);
        graphics.fillOval(kordX + 4, kordY + 10, 17, 17);
        graphics.fillOval(kordX + 28, kordY + 10, 17, 17);

    }

    public int getSuunta() {
        return suunta;
    }

    public void setSuunta(int suunta) {
        this.suunta = suunta;
    }

    public ArrayList<Ammus> getAmmukset() {
        return ammukset;
    }

    public boolean isHengissa() {
        return hengissa;
    }

    public void setHengissa(boolean hengissa) {
        this.hengissa = hengissa;
    }

    /**
     * Antaa rajat, joista lasketaan yyhteentörmäykset
     *
     * @return Ladan rajat
     */
    @Override
    public Rectangle getRajat() {
        return new Rectangle(this.kordX, this.kordY - 10, 50, 35);
    }

    /**
     * Lisää ladan pistesaldoa
     */
    public void saaPiste() {
        this.pisteet++;
    }

    public int getPisteet() {
        return this.pisteet;
    }
}
