package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Book;

import java.sql.SQLException;
import java.util.Properties;

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


    public static void main(String[] args) throws SQLException {
        Book test1 = new Book(1);
        test1.bookTitle = "fellowship of the ring";
        test1.Update();
        Properties data1 = new Properties();
        data1.setProperty("bookId", "1");
        data1.setProperty("bookTitle", "Twenty Thousand Leagues Under the Sea");
        data1.setProperty("author", "Jules Verne");
        data1.setProperty("pubYear", "1870");
        data1.setProperty("status", "Active");
        Book test2 = new Book(data1);
        test2.Update();

        // end of main
        launch(args);
    }
}
