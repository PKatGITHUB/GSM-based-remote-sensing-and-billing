/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selabproject;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class SELabGUITest {
    
    public SELabGUITest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getUsername method, of class SELabGUI.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        SELabGUI instance = new SELabGUI();
    
        instance.setUsername("asd");
        String result = instance.getUsername();
        assertEquals("asd", result);
        
    }

    /**
     * Test of setUsername method, of class SELabGUI.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "asd";
        SELabGUI instance = new SELabGUI();
        instance.setUsername(username);
        assertEquals(username, instance.getUsername());
        
    }

    
    
}
