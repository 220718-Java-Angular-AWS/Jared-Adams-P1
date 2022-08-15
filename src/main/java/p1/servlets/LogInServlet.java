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
import java.io.InputStream;
import java.util.Enumeration;

public class LogInServlet extends HttpServlet {
    private EmployeeService service;
    private ObjectMapper mapper;

    @Override
    public void init() throws ServletException {
        System.out.println("Log-in servlet initializing...");
        this.service = new EmployeeService();
        this.mapper = new ObjectMapper();
        System.out.println("Log-in servlet initialized!");
    }
    @Override
    public void destroy() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String credentials = req.getParameter("credentials");
        String password = req.getParameter("password");

        Employee authenticateEmployee = service.logIn(credentials, password);

        String json = mapper.writeValueAsString(authenticateEmployee);

        resp.getWriter().println(json);

        resp.setStatus(200);
        resp.setContentType("Application/Json; Charset=UTF-8");

    }
}
