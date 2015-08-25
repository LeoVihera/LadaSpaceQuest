/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import kuviot.Hitler;
import kuviot.Lada;
import ladaspacequest.Ennatys;
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
        alusta = new Piirtoalusta(new Ennatys(0));
    }

    @Test
    public void UudelleenPiirtoToimii() throws Exception {
        Thread.sleep(200);
        assertEquals(alusta.getHahmo().getKordY(), 359);
    }

    @Test
    public void SeinienLuominenToimii() throws Exception {
        Thread.sleep(1000);
        alusta.getHahmo().hyppy();
        Thread.sleep(2000);
        assertEquals(alusta.getEsteet().size(), 2);
    }

    @Test
    public void peliPysahtyyLadanMennessaRuudunAlle() throws Exception {
        alusta.getHahmo().setKordY(700);
        Thread.sleep(1000);
        assertEquals(alusta.getHahmo().getKordY(), 701);
    }

    @Test
    public void peliPysahtyyLadanMennessaLiikaaRuudunYlle() throws Exception {
        alusta.getHahmo().setKordY(-40);
        alusta.getHahmo().hyppy();
        Thread.sleep(1000);
        assertEquals(alusta.getHahmo().getKordY(), -65);
    }

    @Test
    public void peliPysahtyyKunLadaTormaa() throws Exception {
        Hitler hitler = new Hitler(5);
        hitler.setKordX(100);
        alusta.getEsteet().add(hitler);
        Thread.sleep(1000);
        assertEquals(alusta.getHahmo().getKordY(), 350);
    }

    @Test
    public void ammusLiikkuu() throws Exception {
        alusta.getHahmo().ammu();
        Thread.sleep(200);
        assertEquals(alusta.getHahmo().getAmmukset().get(0).getKordX(), 190);
    }

    @Test
    public void esteLiikkuu() throws Exception {
        Hitler hitler = new Hitler(5);
        alusta.getEsteet().add(hitler);
        Thread.sleep(200);
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

    @Test
    public void lisaaVaikeuttaPienentaaAjastinta() {
        alusta.lisaaVaikeutta();
        assertEquals(alusta.uusiEste.getDelay(), 980);
    }

    @Test
    public void kunPeliPaattyyLoppuTekstiMuuttuuNakyvaksi() throws Exception {
        Thread.sleep(3000);
        assertEquals(alusta.loppu.isNakyvyys(), true);
    }

    @Test
    public void kunVihollisenKestavysNollaVihollinenKuolee() {
        Hitler hitler = new Hitler(4);
        for (int i = 0; i < 5; i++) {
            hitler.menetaKestavyys();
        }
        alusta.getEsteet().add(hitler);
        alusta.tarkastaEsteidenTuhoutuminen();
        assertEquals(alusta.getEsteet().size(), 0);
    }

    @Test
    public void kunVihollisenVihollinenKuoleePisteetLisaantyvat() {
        Hitler hitler = new Hitler(4);
        for (int i = 0; i < 5; i++) {
            hitler.menetaKestavyys();
        }
        alusta.getEsteet().add(hitler);
        alusta.tarkastaEsteidenTuhoutuminen();
        assertEquals(alusta.getHahmo().getPisteet(), 1);
    }

    @Test
    public void ladaEioleHengissaKunMeneeRuudunAlapuolelle() throws Exception {
        Thread.sleep(3000);
        assertEquals(alusta.getHahmo().isHengissa(), false);
    }

    @Test
    public void esteidenValiaikaEiMeneLiianPieneksi() {
        alusta.uusiEste.setDelay(200);
        alusta.lisaaVaikeutta();
        assertEquals(alusta.uusiEste.getDelay(), 200);
    }

    @Test
    public void kunVihollisenVihollinenKuoleeVaikeusMuuttuu() {
        Hitler hitler = new Hitler(4);
        for (int i = 0; i < 5; i++) {
            hitler.menetaKestavyys();
        }
        alusta.getEsteet().add(hitler);
        alusta.tarkastaEsteidenTuhoutuminen();
        assertEquals(alusta.uusiEste.getDelay(), 980);
    }
}
