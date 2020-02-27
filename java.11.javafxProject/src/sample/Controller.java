package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Book;
import model.BookCollection;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField bookName;
    private BookCollection bEngine = new BookCollection();
    private ObservableList<Book> data;


    @FXML
    private ListView listView = new ListView();

    @FXML
    private void handle(ActionEvent event)
    {
        getBooks();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void getBooks() {
        this.bEngine.findBooksWithTitleLike(this.bookName.getText());
        this.getInitialTableData();
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
}
