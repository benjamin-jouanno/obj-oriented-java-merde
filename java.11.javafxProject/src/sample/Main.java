package sample;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Book;
import model.BookCollection;
import model.Patron;
import model.PatronCollection;

import java.sql.SQLException;
import java.util.Properties;

public class Main extends Application {



    public static void main(String[] args) throws SQLException, IOException {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Book rental");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
