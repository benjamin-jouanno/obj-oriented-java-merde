package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Book;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        /*
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Starfallah");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
         */
    }


    public static void main(String[] args) {

        Book test1 = new Book(1);


        // end of main
        launch(args);
    }
}
