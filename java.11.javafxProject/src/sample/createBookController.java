package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Book;
import model.BookCollection;
import model.Patron;
import model.PatronCollection;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;

public class createBookController {
    @FXML
    private TextField cbookAuthor;
    @FXML
    private TextField cbookPub;
    @FXML
    private TextField cbookStatus;
    @FXML
    private TextField cbookTitle;
    @FXML
    private Button create;
    @FXML
    private Button cancel;
    @FXML
    private Label errorMsg;


    private Properties newBook = new Properties();
    @FXML
    private void createBook() throws SQLException {
        this.newBook.setProperty("bookTitle", this.cbookTitle.getText());
        this.newBook.setProperty("author", this.cbookAuthor.getText());
        this.newBook.setProperty("pubYear", this.cbookPub.getText());
        this.newBook.setProperty("status", this.cbookStatus.getText());
        Book uBook = new Book(this.newBook);
        uBook.Update();
        this.errorMsg.setDisable(false);
        this.errorMsg.setText("Book has been created");
    }

    @FXML
    private void cancel() {
        Stage stage = (Stage) cancel.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
