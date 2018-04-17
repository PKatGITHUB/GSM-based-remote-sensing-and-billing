/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selabproject;

//import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

/**
 *
 * @author admin
 */
public class RunRScript {
    
    RConnection connection = null;
    
    void runScript() throws REngineException {
        try {
            /* Create a connection to Rserve instance running on default port
             * 6311
             */
            connection = new RConnection();
            
            String R_COMMAND_OR_SOURCE_FILE_PATH="source('F:/college study/SEM-6/SOFTWARE ENGINEERING/SE-LAB/GSM-based-remote-sensing-and-billing-master/Detect_Bad_Password.R')";
            
            REXP rResponseObject = connection.parseAndEval("try(eval("+R_COMMAND_OR_SOURCE_FILE_PATH+"),silent=TRUE)");
            
            if (rResponseObject.inherits("try-error")) {
                
               }
            
      
           
        } catch (RserveException e) {
            e.printStackTrace();
        } catch (REXPMismatchException ex) {
            Logger.getLogger(SELabProject.class.getName()).log(Level.SEVERE, null, ex);
        }
        connection.close();
    }
    
}
