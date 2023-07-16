package advanced12th.t1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable { //this class is the Log in form for the app

    @FXML
    private TextField Username;
    @FXML
    private PasswordField Password;

    @FXML
    public Label label;

    public static Scanner x;

    @FXML
    public void LogIn(ActionEvent event) throws IOException {

        String Real_username = Username.getText();//String to store the username

        String Real_password = Password.getText();//String to store the password

        String filepath = ("C:\\Users\\DELL G3\\Documents\\NetBeansProjects\\Advanced12th-T1\\src\\advanced12th\\t1\\members.txt");

        boolean found = false;//boolean flag checking if the certain string is found or not

        String tempUsername = "";

        String tempPassword = "";

        try {
            x = new Scanner(new File(filepath));//Openning the file to scan info
            x.useDelimiter("[,\n]");//function for scanner to make him stop scanning at "\n" or ","

            while (x.hasNext() && !found) {
                tempUsername = x.next();
                tempPassword = x.next();
                //Scanning from the file

                if (tempUsername.trim().equals(Real_username.trim()) && tempPassword.trim().equals(Real_password.trim())) {//comparing the info of the file with the entered username and password
                    Parent MainMenuParent = FXMLLoader.load(getClass().getResource("MainMenu2.fxml"));
                    Scene MainMenuScene = new Scene(MainMenuParent);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(MainMenuScene);
                    stage.show();
                    //entering the next scene if the username and password are correct
                } else {
                    label.setText("Incorrect Username or Password, Try Again");//telling the user that the username or password are wrong
                }
                x.close();//closing file
            }
        } catch (FileNotFoundException e) {
            System.out.println("error");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
