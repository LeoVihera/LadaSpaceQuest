package ladaspacequest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class GameOver {

    private int pisteet;
    private boolean nakyvyys;
    private int kordX = 350;
    private int kordY = 250;

    public GameOver() {
        this.pisteet = 0;
        this.nakyvyys = false;
    }

    public boolean isNakyvyys() {
        return nakyvyys;
    }

    public void setPisteet(int pisteet) {
        this.pisteet = pisteet;
    }

    public void setNakyvyys(boolean nakyvyys) {
        this.nakyvyys = nakyvyys;
    }

    /**
     * Piirtää pelin loppumisilmoituksen, jos nakyvyyys on true
     * 
     * @param graphics 
     */
 
    public void piirra(Graphics graphics) {
        if (this.nakyvyys) {
            graphics.setColor(Color.BLACK);
            graphics.fillRect(kordX, kordY, 300, 200);
            graphics.setColor(new Color(200, 200, 250));
            graphics.fillRect(kordX + 10, kordY + 10, 280, 180);
            graphics.setColor(Color.BLACK);
            graphics.drawString("Kuolit!    Pisteesi:   " + pisteet, kordX + 60, kordY + 60);
            graphics.setFont(new Font("Impact", Font.PLAIN, 18));
            graphics.drawString("Paina R yrittääksesi uudelleen ", kordX + 40, kordY + 110);
            graphics.drawString("Paina T palataksesi valikkoon", kordX + 42, kordY + 140);
            graphics.setFont(new Font("Impact", Font.PLAIN, 24));
        }
    }

}
