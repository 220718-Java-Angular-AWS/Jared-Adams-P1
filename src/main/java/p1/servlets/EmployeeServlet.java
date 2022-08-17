package p1.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;

import p1.pojos.Employee;
import p1.services.EmployeeService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EmployeeServlet extends HttpServlet {
    private EmployeeService service;
    private ObjectMapper mapper;

    @Override
    public void init() throws ServletException {
        System.out.println("Employee servlet initializing...");
        this.service = new EmployeeService();
        this.mapper = new ObjectMapper();
        System.out.println("Employee servlet initialized!");
    }
    @Override
    public void destroy() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("employee-id");

        if(param == null){
            List<Employee> employeeList = service.getListEmployees();
            String json = mapper.writeValueAsString(employeeList);
            resp.getWriter().println(json);
        }else{
            Integer employeeID = Integer.parseInt(req.getParameter("employee-id"));

            Employee employee = service.getEmployee(employeeID);
            String json = mapper.writeValueAsString(employee);
            resp.getWriter().println(json);
        }

        resp.setStatus(200);
        resp.setContentType("Application/Json, Charset=UTF-8");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StringBuilder builder = new StringBuilder();
        BufferedReader buffer = req.getReader();
        while(buffer.ready()) {
            builder.append(buffer.readLine());
        }

        String json = builder.toString();
        Employee newEmployee = mapper.readValue(json, Employee.class);
        service.saveEmployee(newEmployee);

        resp.setStatus(200);
        resp.setContentType("Application/Json, Charset=UTF-8");
    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("employee-id");
        String adminParam = req.getParameter("admin");
        Integer employeeId = Integer.parseInt(param);
        Boolean admin = Boolean.parseBoolean(adminParam);
        if(adminParam != null){
            service.adminUpdate(employeeId, admin);
        }else{
            StringBuilder builder = new StringBuilder();
            BufferedReader buffer = req.getReader();
            while (buffer.ready()){
                builder.append(buffer.readLine());
            }
            String json = builder.toString();
            Employee updateEmployee = mapper.readValue(json, Employee.class);

            service.updateEmployee(updateEmployee, employeeId);
        }
        resp.setStatus(200);
        resp.setContentType("Application/Json, Charset=UTF-8");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("employee-id");
        Integer employeeId = Integer.parseInt(param);
        service.deleteEmployee(employeeId);

        resp.setStatus(200);
        resp.setContentType("Application/Json, Charset=UTF-8");
    }
}
