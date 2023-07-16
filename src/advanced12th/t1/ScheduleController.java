/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class ScheduleController implements Initializable {

    @FXML
    private Label StartLabel_Schedule;

    @FXML
    private Label EndLabel_Schedule;

    @FXML
    private Label Date_Schedule;

    public static Label Start_Static_Schedule;
    public static Label End_Static_Schedule;
    public static Label Date_Static_Schedule;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Start_Static_Schedule = StartLabel_Schedule;
        End_Static_Schedule = EndLabel_Schedule;
        Date_Static_Schedule = Date_Schedule;
    }

    @FXML
    public void GoToHome(ActionEvent event) throws IOException { //switching scene once clicking the button "Home" in the GUI to Mainmenu2 Scene
        Parent MainMenuParent = FXMLLoader.load(getClass().getResource("MainMenu2.fxml"));
        Scene MainMenuScene = new Scene(MainMenuParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(MainMenuScene);
        stage.show();
    }
}
