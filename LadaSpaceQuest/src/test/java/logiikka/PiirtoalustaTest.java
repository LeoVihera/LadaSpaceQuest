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
    public void UudelleenPiirtoToimii() throws Exception{
        Thread.sleep(150);
        assertEquals(alusta.getHahmo().getKordY(), 359);
    }
    
    @Test
    public void SeinienLuominenToimii() throws Exception{
        Thread.sleep(2000);
        assertEquals(alusta.getEsteet().size(), 2);
    }
    
    @Test
    public void peliPysahtyyLadanMennessaRuudunAlle() throws Exception{
        alusta.getHahmo().setKordY(700);
        Thread.sleep(1000);
        assertEquals(alusta.getHahmo().getKordY(), 701);
    }
    
}
