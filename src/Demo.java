import java.sql.*;
import java.*;
import pervasive.jdbc.*;
import java.io.*;

/**
 *
 * @author www.luv2code.com
 */
public class Demo {

    public static void main(String[] args) throws SQLException {

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        String user = "Master";
        String pass = "monitor";
        
        try {
            Class.forName("com.pervasive.jdbc.v2.Driver");

        } catch(Exception e) {
            System.err.print("ClassNotFoundException: ");
            System.out.println(e.toString());
            System.err.println(e.getMessage());

        }

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:pervasive://192.168.2.7:1583/TESTOWA", user, pass);

            // 2. Create a statement
            myStmt = myConn.createStatement();

            // 3. Execute SQL query
            myRs = myStmt.executeQuery("select * from TABELA1");

            // 4. Process the result set
            while (myRs.next()) {
                System.out.println(myRs.getString("imi") + ", " + myRs.getString("nazwisko"));
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
    }    

}