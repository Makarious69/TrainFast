package advanced12th.t1;

import static advanced12th.t1.TicketBookController.ClassTravel;
import static advanced12th.t1.TicketBookController.Static_Price;
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

public class TrainController extends TicketController implements Initializable {

    LuxuryClass tb = new LuxuryClass(0, 0);
    @FXML
    private Label StartLabel;

    @FXML
    private Label EndLabel;

    @FXML
    private Label Date;

    public static Label Start_Static;
    public static Label End_Static;
    public static Label Date_Static;

    @FXML
    public void GoToTicket(ActionEvent event) throws IOException {//switching scene once clicking on the chosen trip in the GUI to Train Scene
        Parent TicketParent = FXMLLoader.load(getClass().getResource("Ticket.fxml"));
        Scene TicketScene = new Scene(TicketParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(TicketScene);
        stage.show();
        Start_Static2.setText(tb.stations[TicketBookController.Start_Location - 1]);
        End_Static2.setText(tb.stations[TicketBookController.End_Location - 1]);
        Date_Static2.setText(TicketBookController.StrTravelDate);
        System.out.println(tb.getDate());
        Class_Static.setText(ClassTravel);
        Price_Static.setText("EGP " + Double.toString(Static_Price));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Start_Static = StartLabel;
        End_Static = EndLabel;
        Date_Static = Date;
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
