/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuviot;

import java.awt.Rectangle;
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
public class AmmusTest {

    public AmmusTest() {
    }

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
    public void ammusLuodaanOikeaanPaikkaan() {
        Lada hahmo = new Lada();
        hahmo.ammu();
        assertEquals(hahmo.getKordX(), hahmo.getAmmukset().get(0).getKordX() - 30);
        assertEquals(hahmo.getKordY(), hahmo.getAmmukset().get(0).getKordY());
    }

    @Test
    public void rajatToimivat() {
        Ammus ammus = new Ammus(0, 0);
        assertEquals(ammus.getRajat(), new Rectangle(0, 0, 10, 3));
    }

    @Test
    public void ammusLiikkuu() {
        Ammus ammus = new Ammus(0, 0);
        for (int i = 0; i < 10; i++) {
        ammus.siirry();
        }
        assertEquals(ammus.getKordX(), 200);
        assertEquals(ammus.getKordY(), 0);
    }
}
