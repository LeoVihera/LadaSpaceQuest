package kuviot;

import java.awt.Graphics;
import java.util.Random;

public class Seina extends Kuvio {

    public Seina(int sijainti) {
        super(1000, 116 * sijainti);
    }

    @Override
    public void siirry() {
        this.kordX = this.kordX - 20;
    }

    @Override
    public void piirra(Graphics graphics) {
        graphics.fillRect(kordX, kordY, 20, 100);

    }
}
