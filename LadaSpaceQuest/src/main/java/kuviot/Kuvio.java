

package kuviot;


import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Kuvio {

    protected int kordX;
    protected int kordY;

    public Kuvio(int x, int y) {
        this.kordX = x;
        this.kordY = y;
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

    public abstract void siirry();
    
    public abstract void piirra(Graphics graphics);
    
    public abstract Rectangle getRajat();
}
