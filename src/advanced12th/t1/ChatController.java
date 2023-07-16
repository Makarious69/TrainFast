package advanced12th.t1;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Administrator
 */
public class ChatController implements Initializable {
    
   
        @FXML
        private TextArea D ;
        @FXML
        private TextField F ;
        DataInputStream in = null;
        Advanced12thT1 main;
        DataOutputStream out= null;


        @FXML   
        private void handleButtonAction(ActionEvent event) throws SQLException, IOException {
          
            
                 String initialString  = D.getText();
                 
                 in = new DataInputStream(new ByteArrayInputStream(initialString.getBytes()));
             
                 out = new DataOutputStream(main.socket.getOutputStream()); 

		String line = ""; 
                try{
                while (!line.equals("Over"))
		{
                    line = in.readLine();
                    out.writeUTF(line);
		}
                }catch(Exception e){
                
                }

       
     }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
