
package model;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;
import javax.swing.JFrame;

// project imports
import database.JDBCBroker;
import database.*;

import impresario.IView;

public class Book extends EntityBase {

    public int bookId; // primary key !
    public String bookTitle;
    public String author;
    public String pubYear;
    public String status;
    private JDBCBroker connector;
    private Statement theStatement = null;
    private Connection theDBConnection = null;

    public Book(Properties _data) {
        super("book");
        if (_data.getProperty("bookId") == null) {
            this.bookId = 0;
            this.bookTitle = _data.getProperty("bookTitle");
            this.author = _data.getProperty("author");
            this.pubYear = _data.getProperty("pubYear");
            this.status = _data.getProperty(("status"));
        }
        else {
            this.bookId = Integer.parseInt(_data.getProperty("bookId"));
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
        if (dataRetrieve.size() == 0) {return ;}
        System.out.println(dataRetrieve);
        this.bookId = Integer.parseInt((dataRetrieve.elementAt(0).getProperty("bookId")));
        this.bookTitle = dataRetrieve.elementAt(0).getProperty("bookTitle");
        this.author = dataRetrieve.elementAt(0).getProperty("author");
        this.pubYear = dataRetrieve.elementAt(0).getProperty("pubYear");
        this.status = dataRetrieve.elementAt(0).getProperty("status");
    }

    public void Update() throws SQLException {
        connector = new JDBCBroker();
        theDBConnection = connector.getConnection();
        theStatement = theDBConnection.createStatement();
        if (this.bookId == 0) {
            String SQLQuery = "INSERT INTO Book(bookTitle, author, pubYear, status) VALUES('" + this.bookTitle + "', '"
                    + this.author + "', '" + this.pubYear + "', '" + this.status + "')";
            System.out.println(theStatement.executeUpdate(SQLQuery));
            System.out.println("Book Saved");
        }
        else {
            String SQLQuery = "UPDATE Book SET bookTitle = '" + this.bookTitle + "', author = '" + this.author + "', pubYear = '"
                    + this.pubYear + "', status = '" + this.status + "' WHERE bookId = " + this.bookId;
            System.out.println(theStatement.executeUpdate(SQLQuery));
            System.out.println("Book Saved");
            return ;
        }
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

