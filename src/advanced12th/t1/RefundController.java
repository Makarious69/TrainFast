package advanced12th.t1;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class RefundController extends MyTripsController implements Initializable {

    static public String Str_Start_Date;

    static public String Str_End_Date;

    @FXML
    private DatePicker Start_Date;

    @FXML
    private DatePicker End_Date;

    public void get_Start_Date(ActionEvent event) { //getting start date entered by user from date picker
        LocalDate myDate = Start_Date.getValue();
        Str_Start_Date = (myDate.toString());
        System.out.println(Str_Start_Date);
    }

    public void get_End_Date(ActionEvent event) { //getting end date entered by user from date picker
        LocalDate myDate = End_Date.getValue();
        Str_End_Date = (myDate.toString());
        System.out.println(Str_End_Date);
    }

    @FXML
    public void GoToMyTrips(ActionEvent event) throws IOException { //switching scene once clicking the button "check" in the GUI to Mytrips Scene
        Parent MyTripsParent = FXMLLoader.load(getClass().getResource("MyTrips.fxml"));
        Scene MyTripsScene = new Scene(MyTripsParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(MyTripsScene);
        stage.show();
        MyTrips_Start_Static.setText(Str_Start_Date);
        MyTrips_End_Static.setText(Str_End_Date);
    }

    @FXML
    public void GoToHome(ActionEvent event) throws IOException { //switching scene once clicking the button "Home" in the GUI to Mainmenu2 Scene
        Parent MainMenuParent = FXMLLoader.load(getClass().getResource("MainMenu2.fxml"));
        Scene MainMenuScene = new Scene(MainMenuParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(MainMenuScene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
