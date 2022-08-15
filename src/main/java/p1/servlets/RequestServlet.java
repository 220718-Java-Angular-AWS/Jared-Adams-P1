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

        if(requestParam == null){
            List<Request> requestList = service.getListRequest();
            String json = mapper.writeValueAsString(requestList);
            resp.getWriter().println(json);
        }else{
            Integer requestId = Integer.parseInt(requestParam);
            Request request = service.getRequest(requestId);
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
        String param = req.getParameter("request-id");
        Integer requestId = Integer.parseInt(param);
        StringBuilder builder = new StringBuilder();
        BufferedReader buffer = req.getReader();
        while (buffer.ready()){
            builder.append(buffer.readLine());
        }

        String json = builder.toString();
        Request updateRequest = mapper.readValue(json, Request.class);

        service.updateRequest(updateRequest, requestId);

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
