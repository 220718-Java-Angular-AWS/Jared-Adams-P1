package p1.daos;

import p1.pojos.Employee;
import p1.services.DataSourceService;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EmployeeDAO implements DataSourceCRUD<Employee> {

    Connection connection;

    public EmployeeDAO() {
        this.connection = DataSourceService.ConnectionManager.getConnection();
    }


    @Override
    public void create(Employee employee) {
        try {
            String sql = "INSERT INTO employees (first_name, last_name, email, username, password, admin)" +
                    " VALUES (?, ?, ?, ?, ?, false)";
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, employee.getFirstName());
            pstmt.setString(2, employee.getLastName());
            pstmt.setString(3, employee.getEmail());
            pstmt.setString(4, employee.getUsername());
            pstmt.setString(5, employee.getPassword());


            pstmt.executeUpdate();
            ResultSet keys = pstmt.getGeneratedKeys();
            if(keys.next()) {
                Integer key = keys.getInt("employee_id");
                System.out.println("Key: " + key);
            }

            String defaultAdmin = "UPDATE employees SET admin = true WHERE employee_id = 1";
            PreparedStatement pstmtDefaultAdmin = connection.prepareStatement(defaultAdmin);

            pstmtDefaultAdmin.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Employee read(int id) {
        Employee employee = new Employee();
        try {
            String sql = "SELECT * FROM employees WHERE employee_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet results = pstmt.executeQuery();

            if (results.next()) {
                employee.setEmployeeId(results.getInt("employee_id"));
                employee.setFirstName(results.getString("first_name"));
                employee.setLastName(results.getString("last_name"));
                employee.setEmail(results.getString("email"));
                employee.setUsername(results.getString("username"));
                employee.setPassword(results.getString("password"));
                employee.setAdmin(results.getBoolean("admin"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> readALL() {
        List<Employee> employeeList = new LinkedList<>();
        try {
            String sql = "SELECT * FROM employees";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet results = pstmt.executeQuery();

            while (results.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(results.getInt("employee_id"));
                employee.setFirstName(results.getString("first_name"));
                employee.setLastName(results.getString("last_name"));
                employee.setEmail(results.getString("email"));
                employee.setUsername(results.getString("username"));
                employee.setPassword(results.getString("password"));
                employee.setAdmin(results.getBoolean("admin"));
                employeeList.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;

    }

    @Override
    public void update(Employee employee, Integer employeeId) {
        try {
            String sql = "UPDATE employees SET first_name = ?, last_name = ?, email = ?, " +
                    "username = ?, password = ? WHERE employee_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, employee.getFirstName());
            pstmt.setString(2, employee.getLastName());
            pstmt.setString(3, employee.getEmail());
            pstmt.setString(4, employee.getUsername());
            pstmt.setString(5, employee.getPassword());
            pstmt.setInt(6, employeeId);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM employees WHERE employee_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            if(id == 1){
                throw new Exception();
            }else{
                pstmt.executeUpdate();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException("Cannot Delete Primary User");
        }
    }

    public Employee logInEmployee(String credentials, String password) {
        Employee employee = new Employee();
        try {
            String sql = "SELECT * FROM employees WHERE email = ? AND password = ? OR username = ? AND password = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, credentials);
            pstmt.setString(2, password);
            pstmt.setString(3, credentials);
            pstmt.setString(4, password);
            ResultSet results = pstmt.executeQuery();

            if (results.next()) {
                employee.setEmployeeId(results.getInt("employee_id"));
                employee.setFirstName(results.getString("first_name"));
                employee.setLastName(results.getString("last_name"));
                employee.setEmail(results.getString("email"));
                employee.setUsername(results.getString("username"));
                employee.setPassword(results.getString("password"));
                employee.setAdmin(results.getBoolean("admin"));

            } else {
                throw new Exception("Incorrect Username/Email or Password");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException("Incorrect Username/Email or Password");
        }
        return employee;
    }
}