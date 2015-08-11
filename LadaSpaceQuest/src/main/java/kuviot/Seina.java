package kuviot;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Seina extends Este {

    public Seina(int sijainti) {
        super(1000, 100 * sijainti);
    }

    @Override
    public void siirry() {
        this.kordX = this.kordX - 15;
    }

    @Override
    public void piirra(Graphics graphics) {
        graphics.fillRect(kordX, kordY, 26, 200);

    }
    
    public Rectangle getRajat(){
        return new Rectangle(this.kordX, this.kordY, 26, 200);
    }
}
