package model;

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

    protected Patron(String tablename) {
        super(tablename);
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