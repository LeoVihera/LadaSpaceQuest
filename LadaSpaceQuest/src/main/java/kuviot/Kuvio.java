

package kuviot;


import java.awt.Graphics;

public abstract class Kuvio {

    protected int kordX;
    protected int kordY;

    public Kuvio(int x, int y) {
        this.kordX = x;
        this.kordY = y;
    }

    public void siirry() {
    }
    
    public void piirra(Graphics graphics){
        
    }
}
