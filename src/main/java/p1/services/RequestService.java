package p1.services;

import p1.daos.RequestDAO;
import p1.pojos.Request;

import java.sql.ResultSet;
import java.util.List;

public class RequestService {

    private RequestDAO dao;

    public RequestService() {
        this.dao = new RequestDAO();
    }

    public void saveRequest(Request request) {
        dao.create(request);
    }

    public Request getRequest(int id) {
        return dao.read(id);
    }
    public Request getSingleRequestForEmployee(int requestId, int employeeId){
        return dao.getSingleRequestForEmployee(requestId, employeeId);
    }
    public Request employeeReadSingleRequest(Integer requestId, Integer employeeId){
        return dao.employeeReadSingleRequest(requestId, employeeId);
    }
    public List<Request> getRequestsForEmployee(int id){
        return dao.readRequestsByEmployee(id);
    }
    public List<Request> readStatus(String status){
        return dao.readStatus(status);
    }

    public List<Request> getListRequest() {
        return dao.readALL();
    }

    public void updateRequest(Request request, Integer requestId, String status) {
        dao.updateStatus(request, requestId, status);
    }
    public void updateRequestById(Request request, Integer requestId, Integer employeeId) {
        dao.update(request, requestId, employeeId);
    }

    public void deleteRequest(int id) {
        dao.delete(id);
    }
}
