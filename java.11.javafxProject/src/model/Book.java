
package model;

import java.util.Properties;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;
import javax.swing.JFrame;

// project imports
import database.*;

import impresario.IView;

public class Book extends EntityBase {

    public int bookId; // primary key !
    public String bookTitle;
    public String author;
    public String pubYear;
    public String status;

    protected Book(Properties _data) {
        super("book");
        if (_data.getProperty("bookId").length() > 0) {
            this.bookId = Integer.parseInt((_data.getProperty("bookId")));
            this.bookTitle = _data.getProperty("bookTitle");
            this.author = _data.getProperty("author");
            this.pubYear = _data.getProperty("pubYear");
            this.status = _data.getProperty(("status"));
        }
    }


    public Book(int _primaryKey) {
        super("book");
        String SQLQuery = "SELECT * FROM Book WHERE bookId = " + _primaryKey;
        Vector <Properties> dataRetrieve = getSelectQueryResult(SQLQuery);
        System.out.println("result = " + dataRetrieve);
    }
    // getters methods

    int getBookId() {
        return (this.bookId);
    }

    String getBookTitle() {
        return (this.bookTitle);
    }

    String getAuthor() {
        return (this.author);
    }

    String getPubYear() {
        return (this.pubYear);
    }

    String getStatus() {
        return (this.status);
    }

    // setters methods

    void setBookId(int _bookId) {
        this.bookId = _bookId;
    }

    void setBookTitle(String _bookTitle) {
        this.bookTitle = _bookTitle;
    }

    void setAuthor(String _author) {
        this.author = _author;
    }

    void setPubYear(String _pubYear) {
        this.pubYear = _pubYear;
    }

    void setStatus(String _status) {
        this.status = _status;
    }

    @Override
    public Object getState(String key) {
        return null;
    }

    @Override
    public void stateChangeRequest(String key, Object value) {

    }

    @Override
    protected void initializeSchema(String tableName) {

    }
}

