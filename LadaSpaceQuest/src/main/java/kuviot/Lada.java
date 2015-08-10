package kuviot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.util.ArrayList;

public class Lada extends Kuvio {

    private int suunta;
    private ArrayList<Ammus> ammukset;

    public Lada() {
        super(100, 350);
        this.suunta = 1;
        this.ammukset = new ArrayList<Ammus>();
    }

    @Override
    public void siirry() {
        if (this.kordY <= -this.suunta) {
            this.suunta = 1;
            this.kordY = 0;
        } else {
            this.kordY = this.kordY + suunta;
            this.suunta = this.suunta + 2;
        }
    }

    public void hyppy() {
        this.suunta = -25;
    }

    public void ammu() {
        this.ammukset.add(new Ammus(this.kordX + 30, this.kordY));
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

    public int getSuunta() {
        return suunta;
    }

    public void setSuunta(int suunta) {
        this.suunta = suunta;
    }

    public ArrayList<Ammus> getAmmukset() {
        return ammukset;
    }

    public void setAmmukset(ArrayList<Ammus> ammukset) {
        this.ammukset = ammukset;
    }


}
