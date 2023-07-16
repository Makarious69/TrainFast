package advanced12th.t1.Server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ServerConnection extends Application {

    ServerSocket socket;
    Button btn = new Button("Send");
    TextArea textarea = new TextArea();
    DataInputStream input = null;

    class Server extends Thread {

        @Override
        public void run() {

            try {
                System.out.println("waiting Connected!");
                socket = new ServerSocket(5000);
                Socket ss = socket.accept();// listhen to Connection  
                System.out.println("Client Connected!");
                textarea.setText(" Client Connected!");
                input = new DataInputStream(new BufferedInputStream(ss.getInputStream()));
                String line = "";

                while (!line.equals("Over")) {
                    line = input.readUTF();
                    textarea.appendText("\n ----->   " + line);
                }

            } catch (Exception E) {
                System.out.println(" Not Connected " + E);
            }

        }

    }

    public VBox vbox() {

        TextField text = new TextField();
        Label label = new Label("Server");
        return new VBox(label, textarea);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        new Server().start();

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

            }
        });

        StackPane root1 = new StackPane();
        root1.getChildren().add(vbox());

        Scene scene = new Scene(root1, 500, 550);

        primaryStage.setTitle(" Server Chat: ");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
