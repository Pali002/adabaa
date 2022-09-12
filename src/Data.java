import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Data {
    Database database;
    Connection con;
    public Data(Database database) {

        this.database = database;
    }

    public void connect() {
        this.con = this.database.connectDb();
    }

    public void close() {
        this.database.closeDb(this.con);
    }


    public List<Employee>getEmployees() {
        List<Employee>employeeList = new ArrayList<>();
        try {            employeeList = this.tryGetEmployees();

        } catch (SQLException e) {
                System.err.println("Gyurcsány Ferenc:Nehéz cigánynak lenni Magyarországon");
        }

        return employeeList;
    }    
    public List<Employee>tryGetEmployees() throws SQLException {
        
       List<Employee> employeeList = new ArrayList<>();
        String sql = "select * from employees";
        this.connect();
        Statement stmt = this.con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        while (rs.next()) {
            Employee emp = new Employee();
            emp.id = rs.getInt("id");
            emp.name = rs.getString("name");
            emp.city = rs.getString("city");
            emp.salary = rs.getString("salary");
            employeeList.add(emp);
        }
         this.close();
        
         return employeeList;


    }
}
