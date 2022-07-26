package p1.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import p1.pojos.Employee;
import p1.pojos.Request;
import p1.services.RequestService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class RequestServlet extends HttpServlet {
    private RequestService service;
    private ObjectMapper mapper;

    @Override
    public void init() throws ServletException {
        System.out.println("Request servlet initializing..");
        this.service = new RequestService();
        this.mapper = new ObjectMapper();
        System.out.println("Request servlet initialized!");
    }
    @Override
    public void destroy() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestParam = req.getParameter("request-id");
        String employeeParam = req.getParameter("employee-id");
        String statusParam = req.getParameter("status");

        if(statusParam == null && requestParam == null && employeeParam == null) {
            List<Request> requestList = service.getListRequest();
            String json = mapper.writeValueAsString(requestList);
            resp.getWriter().println(json);
        }
        if(statusParam == null && requestParam == null && employeeParam != null) {
            Integer employeeId = Integer.parseInt(employeeParam);
            List<Request> request = service.getRequestsForEmployee(employeeId);
            String json = mapper.writeValueAsString(request);
            resp.getWriter().println(json);
        }
        if(statusParam == null && requestParam != null && employeeParam == null) {
            Integer requestId = Integer.parseInt(requestParam);
            Request request = service.getRequest(requestId);
            String json = mapper.writeValueAsString(request);
            resp.getWriter().println(json);
        }
        if(statusParam == null && requestParam != null && employeeParam != null) {
            Integer requestId = Integer.parseInt(requestParam);
            Integer employeeId = Integer.parseInt(employeeParam);
            Request request = service.getSingleRequestForEmployee(requestId, employeeId);
            String json = mapper.writeValueAsString(request);
            resp.getWriter().println(json);
        }
        if (statusParam != null && requestParam == null && employeeParam == null) {
            List<Request> requestList = service.readStatus(statusParam);
            String json = mapper.writeValueAsString(requestList);
            resp.getWriter().println(json);
        }
        if (statusParam != null && requestParam != null && employeeParam != null) {
            Integer requestId = Integer.parseInt(requestParam);
            Integer employeeId = Integer.parseInt(employeeParam);
            Request request = service.employeeReadSingleRequest(requestId, employeeId);
            String json = mapper.writeValueAsString(request);
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

        Request newRequest = mapper.readValue(json, Request.class);
        service.saveRequest(newRequest);


        resp.setStatus(200);
        resp.setContentType("Application/Json, Charset=UTF-8");

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer requestId = Integer.parseInt(req.getParameter("request-id"));
        String employeeParam = req.getParameter("employee-id");
        String status = req.getParameter("status");

        if(employeeParam == null) {
            StringBuilder builder = new StringBuilder();
            BufferedReader buffer = req.getReader();
            while (buffer.ready()){
                builder.append(buffer.readLine());
            }
            String json = builder.toString();
            Request updateRequest = mapper.readValue(json, Request.class);

            service.updateRequest(updateRequest, requestId, status);
        }else{
            Integer employeeId = Integer.parseInt(employeeParam);
            StringBuilder builder = new StringBuilder();
            BufferedReader buffer = req.getReader();
            while (buffer.ready()){
                builder.append(buffer.readLine());
            }
            String json = builder.toString();
            Request updateRequest = mapper.readValue(json, Request.class);

            service.updateRequestById(updateRequest, requestId, employeeId);
        }

        resp.setStatus(200);
        resp.setContentType("Application/Json, Charset=UTF-8");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("request-id");
        Integer requestId = Integer.parseInt(param);
        service.deleteRequest(requestId);
        
        resp.setStatus(200);
        resp.setContentType("Application/Json, Charset=UTF-8");
    }
}
