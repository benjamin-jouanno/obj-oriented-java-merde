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

public class createPatronController {

    @FXML
    private TextField cpatronName;
    @FXML
    private TextField cpatronAddress;
    @FXML
    private TextField cpatronZip;
    @FXML
    private TextField cpatronStateCode;
    @FXML
    private TextField cpatronCity;
    @FXML
    private TextField cpatronEmail;
    @FXML
    private TextField cpatronDateOfBirth;
    @FXML
    private TextField cpatronStatus;
    @FXML
    private Button create;
    @FXML
    private Button cancel;
    @FXML
    private Label errorMsg;

    private Properties newPatron = new Properties();


    @FXML
    private void create() throws SQLException {
    this.newPatron.setProperty("name", this.cpatronName.getText());
    this.newPatron.setProperty("address", this.cpatronAddress.getText());
    this.newPatron.setProperty("city", this.cpatronCity.getText());
    this.newPatron.setProperty("stateCode", this.cpatronStateCode.getText());
    this.newPatron.setProperty("zip", this.cpatronZip.getText());
    this.newPatron.setProperty("email", this.cpatronEmail.getText());
    this.newPatron.setProperty("dateOfBirth", this.cpatronDateOfBirth.getText());
    this.newPatron.setProperty("status", this.cpatronStatus.getText());
    Patron uPatron = new Patron(this.newPatron);
    uPatron.Update();
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
