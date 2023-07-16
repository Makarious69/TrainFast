package advanced12th.t1;

import java.net.Socket;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Advanced12thT1 extends Application {

    static Socket socket;

    static class Client implements Runnable {

        @Override
        public void run() {

            try {

                socket = new Socket("localhost", 5000);
                System.out.println(" Connected!");

            } catch (Exception E) {
                System.out.println(" Not Connected " + E);
            }

        }

    }

    @Override
    public void start(Stage stage) throws Exception {
        Client client = new Client();
        client.run();
        Parent root2 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root2);
        stage.setTitle("TrainFast");
        stage.setScene(scene);
        stage.show();
    }//Start of the GUI of the app, display of FXMLDocument which is Login form

    public static void main(String[] args) {
        launch(args);
    }

}
