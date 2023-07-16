package advanced12th.t1;

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

public class MyTripsController implements Initializable {

    @FXML
    private Label MyTrips_Start;

    @FXML
    private Label MyTrips_End;

    public static Label MyTrips_Start_Static;
    public static Label MyTrips_End_Static;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MyTrips_Start_Static = MyTrips_Start;
        MyTrips_End_Static = MyTrips_End;
    }

    @FXML
    public void GoToHome(ActionEvent event) throws IOException {//switching scene once clicking the button "Home" in the GUI to Mainmenu2 Scene
        Parent MainMenuParent = FXMLLoader.load(getClass().getResource("MainMenu2.fxml"));
        Scene MainMenuScene = new Scene(MainMenuParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(MainMenuScene);
        stage.show();
    }
}
