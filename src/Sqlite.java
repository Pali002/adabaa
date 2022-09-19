import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sqlite implements Database{

    public Connection tryConnectDb() throws SQLException {
        String url = "jdbc:sqlite:adaba.sqlite";
        return DriverManager.getConnection(url);
    }

    @Override
    public Connection connectDb() {
        Connection con  = null;
        try {
            con = tryConnectDb();
        } catch (Exception e) {
            System.err.println("Hiba! Az Sqlite fájl nem nyitható meg");
        }
        return con;
    }

    public void tryCloseDb(Connection con) throws SQLException {
        con.close();
    }

    @Override
    public void closeDb(Connection con) {
        try {
            tryCloseDb(con);
        } catch (SQLException e) {
            System.err.println("Hiba! Az Sqlite adatbázis sbezárása sikertelen");
        }
    }
    
}
