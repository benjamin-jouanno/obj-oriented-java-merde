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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField bookName;
    @FXML
    private TextField bookAuthor;
    @FXML
    private TextField bookPub;
    @FXML
    private TextField patronName;
    @FXML
    private TextField patronZip;
    @FXML
    private Button newBook;
    @FXML
    private Button newPatron;
    private TextField patronAge;
    private BookCollection bEngine = new BookCollection();
    private PatronCollection pEngine = new PatronCollection();
    private Stage bookStage;

    @FXML
    private ListView listView = new ListView();
    @FXML
    private ListView listView2 = new ListView();

    @FXML
    private void handle(ActionEvent event)
    {
        getBooks();
    }

    @FXML
    private void handleAuthor(ActionEvent event)
    {
        getAuthor();
    }

    @FXML
    private void handlePub(ActionEvent event)
    {
        getPub();
    }

    @FXML
    private void handlePatronName(ActionEvent event)
    {
        getPatronName();
    }

    @FXML
    private void handlePatronZip(ActionEvent event)
    {
        getPatronZip();
    }

    @FXML
    private void handlePatronAge(ActionEvent event)
    {
        getPatronAge();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void getPub() {
        this.bEngine.findBooksOlderThanDate(this.bookPub.getText());
        this.getInitialTableData();
    }

    public void getAuthor() {
        this.bEngine.findBooksWithAuthorLike(this.bookAuthor.getText());
        this.getInitialTableData();
    }

    public void getBooks() {
        this.bEngine.findBooksWithTitleLike(this.bookName.getText());
        this.getInitialTableData();
    }

    public void getPatronName() {
        this.pEngine.findPatronsWithNameLike(this.patronName.getText());
        this.getInitialTableDataPatron();
    }

    public void getPatronZip() {
        this.pEngine.findPatronsAtZipCode(this.patronZip.getText());
        this.getInitialTableDataPatron();
    }

    public void getPatronAge() {
        this.pEngine.findPatronsOlderThan(this.patronAge.getText());
        this.getInitialTableDataPatron();
    }

    private void getInitialTableData() {
        this.listView.getItems().clear();
        int i = 0;
        while (i < this.bEngine.bookList.size()) {
            String tempName = this.bEngine.bookList.get(i).BookTitle;
            String tempAuthor = this.bEngine.bookList.get(i).Author;
            listView.getItems().add(tempName + " / writen by / " + tempAuthor );
            i++;
        }
    }

    private void getInitialTableDataPatron() {
        this.listView2.getItems().clear();
        int i = 0;
        while (i < this.pEngine.patronList.size()) {
            String tempName = this.pEngine.patronList.get(i).name;
            listView2.getItems().add("name = " + tempName);
            i++;
        }
    }

    @FXML
    private void newBook() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("createBook.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Create Book");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void newPatron() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("createPatron.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Create Patron");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
