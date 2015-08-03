

package kuviot;


import java.awt.Color;
import java.awt.Graphics;

public class Lada extends Kuvio{
    private int suunta;
    

    public Lada(int x, int y) {
        super(x, y);
        this.suunta = 1;
    }

    
    public void siirry(){
        this.kordY = this.kordY + suunta;
        this.suunta = this.suunta + 1;
    }
    
    public void hyppy(){
        this.suunta = -15;
    }

    public void ammu(){
        
    }

    @Override
    public void piirra(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillRect(kordX, kordY, 50, 20);
        graphics.fillRect(kordX + 10, kordY - 10, 30, 20);
        graphics.setColor(Color.DARK_GRAY);
        graphics.fillOval(kordX + 4, kordY + 10, 17, 17);
        graphics.fillOval(kordX + 28, kordY + 10, 17, 17);
        
        
    }

    public int getKordX() {
        return kordX;
    }

    public void setKordX(int kordX) {
        this.kordX = kordX;
    }

    public int getKordY() {
        return kordY;
    }

    public void setKordY(int kordY) {
        this.kordY = kordY;
    }
}
