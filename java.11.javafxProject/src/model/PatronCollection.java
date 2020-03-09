package model;

import java.util.Properties;
import java.util.Vector;

public class PatronCollection extends EntityBase {

    public Vector <Patron>patronList;

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
            this.patronList.add(temp);
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
            this.patronList.add(temp);
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
            this.patronList.add(temp);
        }
    }

    public void findPatronsWithNameLike(String name)
    {
        this.patronList.clear();
        String SQLQuery = "SELECT * FROM Patron WHERE name LIKE '%" + name + "%'";
        Vector<Properties> dataRetrieve = getSelectQueryResult(SQLQuery);
        if (dataRetrieve.size() == 0)
        {
            return ;
        }
        for (int i = 0; i < dataRetrieve.size(); i++)
        {
            Patron temp = new Patron(dataRetrieve.get(i));
            this.patronList.add(temp);
            System.out.println( i + ": " + dataRetrieve.get(i) + "\n");
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