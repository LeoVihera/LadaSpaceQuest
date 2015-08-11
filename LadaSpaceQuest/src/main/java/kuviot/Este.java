package kuviot;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public abstract class Este extends Kuvio {

    public Este(int x, int y) {
        super(x, y);
    }

    @Override
    public void siirry() {
        this.kordX = this.kordX - 15;
    }
}
