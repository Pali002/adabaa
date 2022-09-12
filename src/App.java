
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Data data = new Data(new Mariadb());
        //data.connect();
        List<Employee> employeeList = data.getEmployees();
        System.out.println(employeeList.get(0).name);
    
    
    }


}
