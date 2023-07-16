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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainMenu2Controller implements Initializable {

    @FXML
    public void GoToTicketBooking(ActionEvent event) throws IOException { //switching scene once clicking the button "Ticket reservation" in the GUI to TicketBook Scene
        Parent TicketBookParent = FXMLLoader.load(getClass().getResource("TicketBook.fxml"));
        Scene TicketBookScene = new Scene(TicketBookParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(TicketBookScene);
        stage.show();
    }

    @FXML
    public void GoToInquiry(ActionEvent event) throws IOException { //switching scene once clicking the button "Inquiry" in the GUI to Inquiry Scene
        Parent InquiryParent = FXMLLoader.load(getClass().getResource("Inquiry.fxml"));
        Scene InquiryScene = new Scene(InquiryParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(InquiryScene);
        stage.show();
    }

    @FXML
    public void GoToRefund(ActionEvent event) throws IOException { //switching scene once clicking the button "Refund" in the GUI to Refund Scene
        Parent RefundParent = FXMLLoader.load(getClass().getResource("Refund.fxml"));
        Scene RefundScene = new Scene(RefundParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(RefundScene);
        stage.show();
    }

    @FXML
    public void GoToTerms(ActionEvent event) throws IOException { //switching scene once clicking the button "Termas & Conditions" in the GUI to Terms Scene
        Parent TermsParent = FXMLLoader.load(getClass().getResource("Terms.fxml"));
        Scene TermsScene = new Scene(TermsParent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(TermsScene);
        stage.show();
    }

    @FXML
    public void GoToChat(ActionEvent event) { //openning new window once clicking the button "chat" in the GUI to Chat Scene
        try {
            FXMLLoader fxmlload = new FXMLLoader(getClass().getResource("Chat.fxml"));
            Parent root3 = (Parent) fxmlload.load();
            Stage stage2 = new Stage();
            stage2.setScene(new Scene(root3));
            stage2.show();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
