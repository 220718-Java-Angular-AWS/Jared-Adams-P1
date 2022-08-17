package p1.services;


import p1.daos.EmployeeDAO;
import p1.pojos.Employee;

import java.sql.ResultSet;
import java.util.List;

public class EmployeeService {
    private EmployeeDAO dao;

    public EmployeeService() {
        this.dao = new EmployeeDAO();
        
    }

    public void saveEmployee(Employee employee) {
        dao.create(employee);

    }

    public Employee getEmployee(int id) {
        return dao.read(id);
    }

    public List<Employee> getListEmployees() {
        return dao.readALL();
    }

    public void updateEmployee(Employee employee, Integer employeeId) {
        dao.update(employee, employeeId);
    }

    public void adminUpdate(Integer employeeId, Boolean admin){
        dao.adminUpdate(employeeId, admin);
    }

    public void deleteEmployee(int id) {
        dao.delete(id);
    }

    public Employee logIn(String credentials, String password) {
        return dao.logInEmployee(credentials, password);
    }
}
