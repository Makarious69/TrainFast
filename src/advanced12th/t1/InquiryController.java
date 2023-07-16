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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.util.*;
import javafx.scene.control.DatePicker;

public class InquiryController extends ScheduleController implements Initializable {

    Ticket in = new LuxuryClass(0, 0);//object of class LuxuryClass that extends Ticket to get Ticket's methods and variables (stations array)

    static public int Start_Location_Inquiry;
    static public int End_Location_Inquiry;

    static public String StrTravelDate_Inquiry;

    @FXML
    private ChoiceBox<String> Departure_Inquiry;

    @FXML
    private ChoiceBox<String> Arrival_Inquiry;

    @FXML
    private DatePicker Travel_Date_Inquiry;

    public void getDate(ActionEvent event) {//getting specified date from date picker

        LocalDate Date = Travel_Date_Inquiry.getValue();
        StrTravelDate_Inquiry = (Date.toString());
        in.setDate(StrTravelDate_Inquiry);
        System.out.println(in.getDate());
    }

    public void getDeparture(ActionEvent event) {//getting departure station from choice box
        String DepartureStation = Departure_Inquiry.getValue();
        System.out.println(DepartureStation);
        int i = 0;
        for (i = 0; i < 10; i++) {
            if (DepartureStation == in.stations[i]) {//for loop to get the order of the chosen station to calculate the price of the ticket
                break;
            }
        }
        Start_Location_Inquiry = i + 1;
        System.out.println(Start_Location_Inquiry);

    }

    public void getArrival(ActionEvent event) {//getting arrival station from choice box
        String ArrivalStation = Arrival_Inquiry.getValue();
        System.out.println(ArrivalStation);
        int j = 0;
        for (j = 0; j < 10; j++) {
            if (ArrivalStation == in.stations[j]) {//for loop to get the order of the chosen station to calculate the price of the ticket
                break;
            }
        }
        End_Location_Inquiry = j + 1;
        System.out.println(End_Location_Inquiry);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Departure_Inquiry.getItems().addAll(in.stations);//adding all the elements in stations array to the choice box
        Departure_Inquiry.setOnAction(this::getDeparture);//implementing getDeparture function once choosing station from the choice box
        Arrival_Inquiry.getItems().addAll(in.stations);//adding all the elements in stations array to the choice box
        Arrival_Inquiry.setOnAction(this::getArrival);//implementing getArrival function once choosing station from the choice box
    }

    @FXML
    public void GoToSchedule(ActionEvent event) throws IOException { //switching scene once clicking the button "CHECK" in the GUI to Schedule Scene
        Parent ScheduleParent = FXMLLoader.load(getClass().getResource("Schedule.fxml"));
        Scene ScheduleScene = new Scene(ScheduleParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(ScheduleScene);
        stage.show();
        Start_Static_Schedule.setText(in.stations[InquiryController.Start_Location_Inquiry - 1]);//setting the label of start station 
        End_Static_Schedule.setText(in.stations[InquiryController.End_Location_Inquiry - 1]);//setting the label of end station 
        Date_Static_Schedule.setText(in.getDate());//setting the date of the trip
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
