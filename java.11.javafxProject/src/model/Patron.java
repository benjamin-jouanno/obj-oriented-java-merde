package model;

import database.JDBCBroker;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;

public class Patron extends EntityBase {

    private int patronId; // primary key
    public String name;
    public String address;
    public String city;
    public String stateCode;
    public String zip;
    public String email;
    public String dateOfBirth;
    public String status;
    private JDBCBroker connector;
    private Statement theStatement = null;
    private Connection theDBConnection = null;


    protected Patron(Properties _data) {
        super("patron");
        if (Integer.parseInt(_data.getProperty("bookId") )> 0) {
            this.patronId = 0;
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



    // getters

    int getPatronId() {
        return (this.patronId);
    }

    String getName() {
        return (this.name);
    }

    String getAddress() {
        return (this.address);
    }

    String getCity() {
        return (this.city);
    }

    String getStateCode() {
        return  (this.stateCode);
    }

    String getZip() {
        return (this.zip);
    }

    String getEmail() {
        return (this.email);
    }

    String getDateOfBirth() {
        return (this.dateOfBirth);
    }

    String getStatus() {
        return  (this.status);
    }
}