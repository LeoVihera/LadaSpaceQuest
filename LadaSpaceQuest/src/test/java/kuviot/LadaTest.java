package kuviot;


import java.awt.Rectangle;
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
public class LadaTest {

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testaaLadanSijaintiY() {
        Lada hahmo = new Lada();
        assertEquals(350, hahmo.getKordY());
    }

    @Test
    public void testaaLadanSijaintiX() {
        Lada hahmo = new Lada();
        assertEquals(100, hahmo.getKordX());
    }

    @Test
    public void ladaLiikkuu() {
        Lada hahmo = new Lada();
        hahmo.siirry();
        assertEquals(351, hahmo.getKordY());
    }

    @Test
    public void hyppyMuuttaaSuunnan() {
        Lada hahmo = new Lada();
        hahmo.hyppy();
        assertEquals(-25, hahmo.getSuunta());
    }

    @Test
    public void ladaEiMeneRuudunylapuolelle() {
        Lada hahmo = new Lada();
        hahmo.setKordY(0);
        hahmo.setSuunta(-1);
        hahmo.siirry();
        assertEquals(0, hahmo.getKordY());
    }

    @Test
    public void suuntaKasvaaSiirryttaessa() {
        Lada hahmo = new Lada();
        hahmo.siirry();
        assertEquals(3, hahmo.getSuunta());
    }

    @Test
    public void ampuminentoimii() {
        Lada hahmo = new Lada();
        for (int i = 0; i < 10; i++) {
            hahmo.ammu();
        }
        assertEquals(10, hahmo.getAmmukset().size());
    }
    
    
    @Test
    public void ladaEiMeneRuudustaYli(){
        Lada hahmo = new Lada();
        hahmo.setKordY(25);
        hahmo.hyppy();
        hahmo.siirry();
        assertEquals(hahmo.getKordY(), 0);
        assertEquals(hahmo.getSuunta(), 1);
    }
    
    @Test
    public void rajatOvatOikein(){
        Lada hahmo = new Lada();
        hahmo.hyppy();
        hahmo.siirry();
        assertEquals(hahmo.getRajat(), new Rectangle(100, 315, 50, 35));
    }
    

}
