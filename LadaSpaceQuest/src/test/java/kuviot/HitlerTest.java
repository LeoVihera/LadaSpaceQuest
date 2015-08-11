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
public class HitlerTest {
    
    public HitlerTest() {
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
    public void luodaanOikeaanPaikkaanJaSiirtyy(){
        Hitler hitler = new Hitler(2);
        hitler.siirry();
        assertEquals(hitler.kordX, 985);
        assertEquals(hitler.kordY, 140);
    }
    
    @Test
    public void testaaRajat(){
        Hitler hitler = new Hitler(4);
        hitler.setKordX(300);
        assertEquals(hitler.getRajat(), new Rectangle(300, 280, 65, 100));
    }
}
