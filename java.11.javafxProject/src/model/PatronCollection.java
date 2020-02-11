package model;

import java.util.Properties;
import java.util.Vector;

public class PatronCollection extends EntityBase {

    Vector <Patron>patronList;

    public PatronCollection()
    {
        super("PatronCollection");
        this.patronList = new Vector<Patron>();
    }


    public void findPatronsOlderThan(String date)
    {
        this.patronList.clear();
        String SQLQuery = "SELECT * FROM Patron WHERE dateOfBirth < '" + date + "'";
        Vector<Properties> dataRetrieve = getSelectQueryResult(SQLQuery);
        if (dataRetrieve.size() == 0) {return ;}
        for (int i = 0; i < dataRetrieve.size(); i++)
        {
            System.out.println( i + ": " + dataRetrieve.get(i) + "\n");
            Patron temp = new Patron(dataRetrieve.get(i));
        }
    }

    public void findPatronsYoungerThan(String date)
    {
        this.patronList.clear();
        String SQLQuery = "SELECT * FROM Patron WHERE dateOfBirth > '" + date + "'";
        Vector<Properties> dataRetrieve = getSelectQueryResult(SQLQuery);
        if (dataRetrieve.size() == 0) {return ;}
        for (int i = 0; i < dataRetrieve.size(); i++)
        {
            System.out.println( i + ": " + dataRetrieve.get(i) + "\n");
            Patron temp = new Patron(dataRetrieve.get(i));
        }
    }

    public void findPatronsAtZipCode(String zip)
    {
        this.patronList.clear();
        String SQLQuery = "SELECT * FROM Patron WHERE zip LIKE '%" + zip + "%'";
        Vector<Properties> dataRetrieve = getSelectQueryResult(SQLQuery);
        if (dataRetrieve.size() == 0)
        {
            return ;
        }
        for (int i = 0; i < dataRetrieve.size(); i++)
        {
            System.out.println( i + ": " + dataRetrieve.get(i) + "\n");
            Patron temp = new Patron(dataRetrieve.get(i));
        }
    }

    public void findPatronsWithNameLike(String name)
    {
        this.patronList.clear();
        String SQLQuery = "SELECT * FROM Patron WHERE zip LIKE '%" + name + "%'";
        Vector<Properties> dataRetrieve = getSelectQueryResult(SQLQuery);
        if (dataRetrieve.size() == 0)
        {
            return ;
        }
        for (int i = 0; i < dataRetrieve.size(); i++)
        {
            System.out.println( i + ": " + dataRetrieve.get(i) + "\n");
            Patron temp = new Patron(dataRetrieve.get(i));
        }
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