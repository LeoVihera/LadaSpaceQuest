

package kuviot;


import java.awt.Graphics;

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

    public void siirry() {
    }
    
    public void piirra(Graphics graphics){
        
    }
}
