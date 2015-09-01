package kuviot;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * Luokka, joka sisältää viholliskuvion metodit
 * @author Leo
 */
public class Hitler extends Este {

    private final BufferedImage kuva;
    private int kestavyys;

    public Hitler(int sijainti) {
        super(1000, 70 * sijainti);
        BufferedImage img = null;
        try {
            img = ImageIO.read(this.getClass().getResource("/hitlerala1.png"));
        } catch (IOException e) {
        }
        this.kuva = img;
        this.kestavyys = 5;
    }

    /**
     * Siirtää vihollista
     */
    @Override
    public void siirry() {
        this.kordX = this.kordX - 15;
    }


    /**
     * Piirtää vihollishahmon
     * @param graphics 
     */
    @Override
    public void piirra(Graphics graphics) {
            graphics.drawImage(kuva, this.kordX, this.kordY, null);
    }

    /**
     * Palauttaa rajat, joista lasketaan yhteentörmäykset
     * @return Vihollisen rajat
     */
    @Override
    public Rectangle getRajat() {
        return new Rectangle(this.kordX, this.kordY, 65, 100);
    }
      
    /**
     * Vähentää vihollisen kestävyyspisteitä, joista lasketaan, milloin vihollinen tuhoutuu
     */
    @Override
    public void menetaKestavyys(){
        this.kestavyys--;
    }

    @Override
    public int getKestavyys() {
        return kestavyys;
    }
    

}
