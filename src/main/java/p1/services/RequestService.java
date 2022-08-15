package p1.services;

import p1.daos.RequestDAO;
import p1.pojos.Request;

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
    public List<Request> getRequestForEmployee(int id){
        return dao.readRequestByEmployee(id);
    }

    public List<Request> getListStatus(Boolean status){
        return dao.readStatus(status);
    }

    public List<Request> getListRequest() {
        return dao.readALL();
    }

    public void updateRequest(Request request, Integer requestId) {
        dao.update(request, requestId);
    }

    public void deleteRequest(int id) {
        dao.delete(id);
    }
}
