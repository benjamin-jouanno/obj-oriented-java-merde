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
        Properties newBook = new Properties();
        Properties newPatron = new Properties();
        BookCollection searchBEngine = new BookCollection();
        PatronCollection searchPEngine = new PatronCollection();
        String searchTitle;
        String searchYear;
        String searchDate;
        String searchZip;

        //Enter data using BufferReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Hello, welcome to this demo.\n");
        System.out.println("We are going to create a Book.\n Please enter your Book title:");
        newBook.setProperty("bookTitle", reader.readLine());
        System.out.println("Name saved.\n Please enter your Book's author:");
        newBook.setProperty("author", reader.readLine());
        System.out.println("Author saved.\n Please enter your Book's publication year (must be '0000'):");
        newBook.setProperty("pubYear", reader.readLine());
        System.out.println("pubYear saved.\n Please enter your Book's status (must be Active or Inactive):");
        newBook.setProperty("status", reader.readLine());
        System.out.println("Status saved.\n Please enter your Book's author:");

        System.out.println("\n----------- Waiting for database to process data -----------\n");

        Book enterData = new Book(newBook);
        enterData.Update();

        System.out.println("Now we are going to create a new Patron.\n");
        System.out.println("Please enter your patron name:");
        newPatron.setProperty("name", reader.readLine());
        System.out.println("Name saved.\n Please enter your patron's address:");
        newPatron.setProperty("address", reader.readLine());
        System.out.println("Address saved.\n Please enter your patron's city:");
        newPatron.setProperty("city", reader.readLine());
        System.out.println("City saved.\n Please enter your patron's stateCode (must be '00'):");
        newPatron.setProperty("stateCode", reader.readLine());
        System.out.println("StateCode saved.\n Please enter your patron's zip:");
        newPatron.setProperty("zip", reader.readLine());
        System.out.println("Zip saved.\n Please enter your patron's email:");
        newPatron.setProperty("email", reader.readLine());
        System.out.println("Email saved.\n Please enter your patron's dateOfBirth (must be like 'YYYY-MM-dd):");
        newPatron.setProperty("dateOfBirth", reader.readLine());
        System.out.println("DateOfBirth saved.\n Please enter your patron's status (must be Active or Inactive):");
        newPatron.setProperty("status", reader.readLine());
        System.out.println("Status saved \n");

        System.out.println("\n----------- Waiting for database to process data -----------\n");
        Patron enterNewPatron = new Patron(newPatron);
        enterNewPatron.Update();


        System.out.println("Now we are going to search for book content in our Database \n");
        System.out.println("Looking for a book by title.\n please enter a book title:");
        searchTitle = reader.readLine();

        System.out.println("\n----------- Waiting for database to process data -----------\n");
        searchBEngine.findBooksWithTitleLike(searchTitle);

        System.out.println("Looking for a book by date before.\n please enter a publication year (ex: '1853'):");
        searchYear = reader.readLine();

        System.out.println("\n----------- Waiting for database to process data -----------\n");
        searchBEngine.findBooksOlderThanDate(searchYear);

        System.out.println("Now we are going to search for patron content in our Database \n");
        System.out.println("Looking for a patron by younger than a date.\n please enter a date (ex: '1997-05-23):");
        searchDate = reader.readLine();

        System.out.println("\n----------- Waiting for database to process data -----------\n");
        searchPEngine.findPatronsYoungerThan(searchDate);

        System.out.println("Looking for a patron by a zip.\n please enter a zip (ex: '31600):");
        searchZip = reader.readLine();

        System.out.println("\n----------- Waiting for database to process data -----------\n");
        searchPEngine.findPatronsAtZipCode(searchZip);

        System.out.println("\n" +
                " ________                  __                   ______           __                            __      __                     \n" +
                "|        \\                |  \\                 /      \\         |  \\                          |  \\    |  \\                    \n" +
                "| $$$$$$$$ _______    ____| $$        ______  |  $$$$$$\\       _| $$_     ______    _______  _| $$_    \\$$ _______    ______  \n" +
                "| $$__    |       \\  /      $$       /      \\ | $$_  \\$$      |   $$ \\   /      \\  /       \\|   $$ \\  |  \\|       \\  /      \\ \n" +
                "| $$  \\   | $$$$$$$\\|  $$$$$$$      |  $$$$$$\\| $$ \\           \\$$$$$$  |  $$$$$$\\|  $$$$$$$ \\$$$$$$  | $$| $$$$$$$\\|  $$$$$$\\\n" +
                "| $$$$$   | $$  | $$| $$  | $$      | $$  | $$| $$$$            | $$ __ | $$    $$ \\$$    \\   | $$ __ | $$| $$  | $$| $$  | $$\n" +
                "| $$_____ | $$  | $$| $$__| $$      | $$__/ $$| $$              | $$|  \\| $$$$$$$$ _\\$$$$$$\\  | $$|  \\| $$| $$  | $$| $$__| $$\n" +
                "| $$     \\| $$  | $$ \\$$    $$       \\$$    $$| $$               \\$$  $$ \\$$     \\|       $$   \\$$  $$| $$| $$  | $$ \\$$    $$\n" +
                " \\$$$$$$$$ \\$$   \\$$  \\$$$$$$$        \\$$$$$$  \\$$                \\$$$$   \\$$$$$$$ \\$$$$$$$     \\$$$$  \\$$ \\$$   \\$$ _\\$$$$$$$\n" +
                "                                                                                                                    |  \\__| $$\n" +
                "                                                                                                                     \\$$    $$\n" +
                "                                                                                                                      \\$$$$$$ \n");

        System.out.println("\n--------------------------------------\n");
        System.out.println("------------ Arthur Costil -----------\n");
        System.out.println("---------- Benjamin Jouanno ----------\n");
        System.out.println("--------------------------------------\n");


        System.out.println(" _______  _____  _____ _______ _______ _______ _     _\n" +
                " |______ |_____]   |      |    |______ |       |_____|\n" +
                " |______ |       __|__    |    |______ |_____  |     |\n" +
                "                                                      ");
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
