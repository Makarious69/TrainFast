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

public class TicketBookController extends TrainController implements Initializable {

    Ticket tb = new LuxuryClass(0, 0);   //polymorphism

    static public int Start_Location;
    static public int End_Location;
    static public String StrTravelDate;
    static public String ClassTravel;
    static public double Static_Price;

    @FXML
    private ChoiceBox<String> Departure;

    @FXML
    private ChoiceBox<String> Arrival;

    @FXML
    private ChoiceBox<String> Class_ChoiceBox;
    private String[] Classes = {"First", "Second", "Luxury"};//array of classes names 

    @FXML
    private DatePicker Travel_Date;

    public void getDate(ActionEvent event) { //getting the date of the trip from date picker
        LocalDate myDate = Travel_Date.getValue();
        StrTravelDate = (myDate.toString());
        tb.setDate(StrTravelDate);
        System.out.println(tb.getDate());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Departure.getItems().addAll(tb.stations);//adding all the elements in stations array to the choice box
        Departure.setOnAction(this::getDeparture);//implementing getDeparture function once choosing station from the choice box
        Arrival.getItems().addAll(tb.stations);//adding all the elements in stations array to the choice box
        Arrival.setOnAction(this::getArrival);//implementing getArrival function once choosing station from the choice box
        Class_ChoiceBox.getItems().addAll(Classes);//adding all the elements in Classes array to the choice box
        Class_ChoiceBox.setOnAction(this::getClass);//implementing getClass function once choosing station from the choice box
    }

    public void getDeparture(ActionEvent event) {
        String DepartureStation = Departure.getValue();
        System.out.println(DepartureStation);
        int i = 0;
        for (i = 0; i < 10; i++)//for loop to get the order of the chosen station to calculate the price of the ticket
        {
            if (DepartureStation == tb.stations[i]) {
                break;
            }
        }
        Start_Location = i + 1;
        System.out.println(Start_Location);
    }

    public void getArrival(ActionEvent event) {
        String ArrivalStation = Arrival.getValue();
        System.out.println(ArrivalStation);
        int j = 0;
        for (j = 0; j < 10; j++)//for loop to get the order of the chosen station to calculate the price of the ticket
        {
            if (ArrivalStation == tb.stations[j]) {
                break;
            }
        }
        End_Location = j + 1;
        System.out.println(End_Location);
    }

    public void getClass(ActionEvent event) {
        ClassTravel = Class_ChoiceBox.getValue();
        System.out.println(ClassTravel);
        if (ClassTravel == "Luxury")//if condition to calculate the price of the ticket depending on the class chosen
        {
            LuxuryClass Luxury = new LuxuryClass(Start_Location, End_Location);
            Luxury.setPayment(Luxury.payment());
            Static_Price = Luxury.getPayment();
        } else if (ClassTravel == "First") {
            FirstClass First = new FirstClass(Start_Location, End_Location);
            First.setPayment(First.payment());
            Static_Price = First.getPayment();
        } else {
            SecondClass Second = new SecondClass(Start_Location, End_Location);
            Second.setPayment(Second.payment());
            Static_Price = Second.getPayment();
        }
    }

    @FXML
    public void GoToTrain(ActionEvent event) throws IOException {//switching scene once clicking on the button "check" in the GUI to Train Scene
        Parent TrainParent = FXMLLoader.load(getClass().getResource("Train.fxml"));
        Scene TrainScene = new Scene(TrainParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(TrainScene);
        stage.show();
        Start_Static.setText(tb.stations[TicketBookController.Start_Location - 1]);
        End_Static.setText(tb.stations[TicketBookController.End_Location - 1]);
        Date_Static.setText(tb.getDate());
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
