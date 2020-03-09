package model;

import database.JDBCBroker;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;

public class Patron extends EntityBase {

    private int patronId; // primary key
    public String name = null;
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


    public Patron(Properties _data) {
        super("patron");
        if ((_data.getProperty("patronId") == null)){
            this.patronId = 0;
            this.name = _data.getProperty("name");
            this.address = _data.getProperty("address");
            this.city = _data.getProperty("city");
            this.stateCode = _data.getProperty("stateCode");
            this.zip = _data.getProperty("zip");
            this.email = _data.getProperty("email");
            this.dateOfBirth = _data.getProperty("dateOfBirth");
            this.status = _data.getProperty("status");
        }
    }

    public Patron(int _primaryKey) {
        super("patron");
        String SQLQuery = "SELECT * FROM Patron WHERE patronId = " + _primaryKey;
        Vector<Properties> dataRetrieve = getSelectQueryResult(SQLQuery);
        System.out.println(dataRetrieve);
        if (dataRetrieve.size() == 0) {return ;}
        this.patronId = Integer.parseInt(dataRetrieve.elementAt(0).getProperty("patronId"));
        this.name = dataRetrieve.elementAt(0).getProperty("name");
        this.address = dataRetrieve.elementAt(0).getProperty("address");
        this.city = dataRetrieve.elementAt(0).getProperty("city");
        this.stateCode = dataRetrieve.elementAt(0).getProperty("stateCode");
        this.zip = dataRetrieve.elementAt(0).getProperty("zip");
        this.email = dataRetrieve.elementAt(0).getProperty("email");
        this.dateOfBirth = dataRetrieve.elementAt(0).getProperty("dateOfBirth");
        this.status = dataRetrieve.elementAt(0).getProperty("status");
    }

    public void Update() throws SQLException {
        connector = new JDBCBroker();
        theDBConnection = connector.getConnection();
        theStatement = theDBConnection.createStatement();
        System.out.println(this.patronId);

        if (this.patronId == 0)
        {
            String SQLQuery = "INSERT INTO Patron(name, address, city, stateCode, zip, email, dateOfBirth, status) VALUES('"
                    + this.name + "', '"
                    + this.address + "', '"
                    + this.city + "', '"
                    + this.stateCode + "', '"
                    + this.zip + "', '"
                    + this.email + "', '"
                    + this.dateOfBirth + "', '"
                    + this.status + "')";
            System.out.println(theStatement.executeUpdate(SQLQuery));
            System.out.println("Patron Saved");
        }
        else {
            String SQLQuery = "UPDATE Patron SET name = '" + this.name
                    + "', address = '" + this.address
                    + "', city = '" + this.city
                    + "', stateCode = '" + this.stateCode
                    + "', zip = '" + this.zip
                    + "', email = '" + this.email
                    + "', dateOfBirth = '" + this.dateOfBirth
                    + "', status = '" + this.status
                    + "' WHERE patronId = " + this.patronId;
            System.out.println(theStatement.executeUpdate(SQLQuery));
            System.out.println("Patron Saved");
            return ;
        }
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

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public Object getState(String key)
    {
        return null;
    }

    @Override
    public void stateChangeRequest(String key, Object value)
    {}

    @Override
    protected void initializeSchema(String tableName)
    {}
}