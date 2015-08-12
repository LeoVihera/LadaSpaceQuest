/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import kuviot.Hitler;
import kuviot.Lada;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leo
 */
public class PiirtoalustaTest {

    Piirtoalusta alusta;

    @Before
    public void setUp() {
        alusta = new Piirtoalusta();
    }

    @Test
    public void UudelleenPiirtoToimii() throws Exception {
        Thread.sleep(150);
        assertEquals(alusta.getHahmo().getKordY(), 359);
    }

    @Test
    public void SeinienLuominenToimii() throws Exception {
        Thread.sleep(2001);
        assertEquals(alusta.getEsteet().size(), 2);
    }

    @Test
    public void peliPysahtyyLadanMennessaRuudunAlle() throws Exception {
        alusta.getHahmo().setKordY(700);
        Thread.sleep(1000);
        assertEquals(alusta.getHahmo().getKordY(), 701);
    }

//    @Test
//    public void peliPysahtyyKunLadaTormaa() throws Exception {
//        Hitler hitler = new Hitler(5);
//        hitler.setKordX(105);
//        alusta.getEsteet().add(hitler);
//        Thread.sleep(1000);
//        assertEquals(alusta.getHahmo().getKordY(), 351);
//    }
    @Test
    public void ammusLiikkuu() throws Exception {
        alusta.getHahmo().ammu();
        Thread.sleep(150);
        assertEquals(alusta.getHahmo().getAmmukset().get(0).getKordX(), 190);
    }

    @Test
    public void esteLiikkuu() throws Exception {
        Hitler hitler = new Hitler(5);
        alusta.getEsteet().add(hitler);
        Thread.sleep(150);
        assertEquals(alusta.getEsteet().get(0).getKordX(), 955);
    }

    @Test
    public void ammusTuhoutuuOsuessaanEsteeseen() throws Exception {
        Hitler hitler = new Hitler(5);
        hitler.setKordX(200);
        alusta.getEsteet().add(hitler);
        alusta.getHahmo().ammu();
        Thread.sleep(300);
        assertEquals(alusta.getHahmo().getAmmukset().size(), 0);
    }
}
