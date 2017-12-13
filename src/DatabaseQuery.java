import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.*;

/**
 * Created by Joshua Powell on 11/25/2017.
 */

public class DatabaseQuery extends Thread  {

	//The variable that will hold the first condition to check in the query 
	//that is passed to the constructor.
    private String condition_one = "";

    /**
     * This is the constructor for the class. 
     * By default it takes one condition and passes that to an instance variable.
     * @param conditionOne
     * This parameter is the first condition to check in the query.
     */
    public DatabaseQuery(String conditionOne)
    {
        condition_one = conditionOne;
    }

    /**
     * This is the class run method. Since the class extends thread it is required to run the class. 
     */
    @Override
    public void run() {
        super.run();

        try {
        	//Getting the correct driver to use and then making a connection to the database.
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://(server)/(database)","(username)", "(password)");
            
            //Creating a statement and then getting the results in the form of a ResultSet
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from (Database) WHERE (Column) = '" + condition_one + "'");
            
            //Loop through the ResultSet
            while(rs.next()) {
                //Do something with data
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

}
