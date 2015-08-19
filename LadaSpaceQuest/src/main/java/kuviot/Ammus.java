package kuviot;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Luokka ladan ammukselle
 */
public class Ammus extends Kuvio {

    public Ammus(int x, int y) {
        super(x, y);
    }

    /**
     * Metodi, joka piirtää ammuksen
     * 
     * @param graphics 
     */
    @Override
    public void piirra(Graphics graphics) {
        graphics.fillRect(kordX, kordY, 10, 3);
    }

    /**
     * Siirtää ammusta
     */
    @Override
    public void siirry() {
        this.kordX = this.kordX + 20;
    }

    @Override
    public Rectangle getRajat() {
        return new Rectangle(this.kordX, this.kordY, 10, 3);
    }
}
