import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Mariadb implements Database {
    public Connection connectDb() {
        Connection con = null;
        try {
            con = tryConnectDb();
        } catch (SQLException e) {
            System.err.println("hiba!A kapcsolat nem müködik");
        }
        return con;
    }
    public Connection tryConnectDb() throws SQLException {
        Connection con = null;
        String url = "jdbc:mariadb://localhost:3306/adaba";
        String user = "adaba";
        String pass = "titok";
        con = DriverManager.getConnection(url, user, pass);

        return con;
    }
    public void closeDb(Connection con) {

        try { 
            tryCloseDb(con);    
        
        } catch (SQLException e) 
        
        {
            System.err.println("hiba!A bezárás sikertelen");
        }
        
    }
    public void tryCloseDb(Connection con) throws SQLException{
        con.close();
    
    }
   
}

