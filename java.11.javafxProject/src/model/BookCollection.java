package model;

import java.util.List;
import java.util.Properties;
import java.util.Vector;

public class BookCollection extends EntityBase {

    public Vector <Book>bookList;

    public BookCollection() {
        super("BookCollection");
        this.bookList = new Vector<Book>();
    }


    public void findBooksOlderThanDate(String date) {
        this.bookList.clear();
        String SQLQuery = "SELECT * FROM Book WHERE pubYear < " + date;
        Vector <Properties> dataRetrieve = getSelectQueryResult(SQLQuery);
        if (dataRetrieve == null) {return ;}
        for (int i = 0; i < dataRetrieve.size(); i++) {
            Book temp = new Book(dataRetrieve.get(i));
            this.bookList.add(temp);
            System.out.println( i + ": " + dataRetrieve.get(i) + "\n");
        }
    }

    public void findBooksNewerThanDate(String date) {
        this.bookList.clear();
        String SQLQuery = "SELECT * FROM Book WHERE pubYear > " + date;
        Vector <Properties> dataRetrieve = getSelectQueryResult(SQLQuery);
        if (dataRetrieve == null) {return ;}
        for (int i = 0; i < dataRetrieve.size(); i++) {
            Book temp = new Book(dataRetrieve.get(i));
            this.bookList.add(temp);
            System.out.println( i + ": " + dataRetrieve.get(i) + "\n");
        }
    }

    public void findBooksWithTitleLike(String title) {
        this.bookList.clear();
        String SQLQuery = "SELECT * FROM Book WHERE bookTitle LIKE " + "'%" + title + "%'";
        Vector <Properties> dataRetrieve = getSelectQueryResult(SQLQuery);
        if (dataRetrieve == null) {return ;}
        for (int i = 0; i < dataRetrieve.size(); i++) {
            Book temp = new Book(dataRetrieve.get(i));
            this.bookList.add(temp);
            System.out.println( i + ": " + dataRetrieve.get(i) + "\n");
        }
    }

    public void findBooksWithAuthorLike(String author) {
        this.bookList.clear();
        String SQLQuery = "SELECT * FROM Book WHERE author LIKE " + "'%" + author + "%'";
        Vector <Properties> dataRetrieve = getSelectQueryResult(SQLQuery);
        if (dataRetrieve == null) {return ;}
        for (int i = 0; i < dataRetrieve.size(); i++) {
            Book temp = new Book(dataRetrieve.get(i));
            this.bookList.add(temp);
            System.out.println( i + ": " + dataRetrieve.get(i) + "\n");
        }
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
