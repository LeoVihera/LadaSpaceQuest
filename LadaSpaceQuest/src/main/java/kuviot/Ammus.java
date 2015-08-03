

package kuviot;


import java.awt.Graphics;

public class Ammus extends Kuvio{

    public Ammus(int x, int y) {
        super(x, y);
    }
    @Override
    public void piirra(Graphics graphics){
        graphics.fillRect(kordX, kordY, 3, 10);
    }
}

 