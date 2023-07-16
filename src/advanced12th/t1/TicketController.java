package advanced12th.t1;

import static advanced12th.t1.TrainController.Date_Static;
import static advanced12th.t1.TrainController.End_Static;
import static advanced12th.t1.TrainController.Start_Static;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TicketController implements Initializable {

    @FXML
    private Label StartLabel2;
    
    @FXML
    private Label EndLabel2;
    
    @FXML
    private Label Date2;
    
    @FXML
    private Label Class2;
    @FXML
    private Label Price2;
    
    
    public static Label Class_Static;
    public static Label Price_Static;
    public static Label Start_Static2;
    public static Label End_Static2;
    public static Label Date_Static2;
    
    @FXML
    public void GoToPay(ActionEvent event) throws IOException {//switching scene once clicking the button "Pay" in the GUI to Pay Scene
        Parent PayParent = FXMLLoader.load(getClass().getResource("Pay.fxml"));
        Scene PayScene = new Scene(PayParent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(PayScene);
        stage.show();
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Start_Static2 = StartLabel2;
        End_Static2 = EndLabel2;
        Date_Static2 = Date2;
        Class_Static = Class2;
        Price_Static = Price2;
        
    }    
    
    
    @FXML
    public void GoToHome(ActionEvent event) throws IOException {//switching scene once clicking the button "Home" in the GUI to Mainmenu2 Scene
        Parent MainMenuParent = FXMLLoader.load(getClass().getResource("MainMenu2.fxml"));
        Scene MainMenuScene = new Scene(MainMenuParent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(MainMenuScene);
        stage.show();
    }
}
