/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selabproject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class RunRScriptTest {
    
    public RunRScriptTest() {
    }
    

    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of runScript method, of class RunRScript.
     */
    @Test
    public void testRunScript_shouldRunSuccessfully() throws Exception {
        System.out.println("runScript");
        RunRScript instance = new RunRScript();
        instance.runScript();
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
