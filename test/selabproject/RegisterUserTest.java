/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selabproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class RegisterUserTest {
    
    public RegisterUserTest() {
    }
    
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of registerNewUser method, of class RegisterUser.
     */
    @Test
    public void testRegisterNewUser_shouldRunSuccessfully() {
        
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        String DB_URL = "jdbc:mysql://localhost:3306/selab";

        //  Database credentials
        String USER = "root";
        String PASS = "password";

        Connection conn = null;
        Statement stmt = null;
        
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
      
        
       
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        
           System.out.println("Connected database successfully...");
        
            stmt=conn.createStatement();
            String insertBasicInformation="DELETE FROM `basic_user_information` WHERE `basic_user_information`.`Username` = \'userName\'";
            stmt.executeUpdate(insertBasicInformation);
            
        }catch(SQLException e){
            System.out.print("Exception");
        } catch (Exception ex) {
            Logger.getLogger(SELabGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        System.out.println("registerNewUser");
        String firstName = "firstName";
        String lastName = "lastName";
        String userName = "userName";
        String emailId = "emailId";
        String password = "password";
        String userType = "userType";
        String deviceId = "deviceId";
        
        
        
        RegisterUser instance = new RegisterUser();
        
        
        
        
        
        boolean result = instance.registerNewUser(firstName, lastName, userName, emailId, password, userType, deviceId);
        
        assertEquals(true, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
   
    
}
