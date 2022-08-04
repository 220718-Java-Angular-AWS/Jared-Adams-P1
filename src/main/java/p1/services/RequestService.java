package p1.services;

import p1.daos.RequestDAO;
import p1.pojos.Request;

import java.util.List;

public class RequestService {

    private RequestDAO dao;

    public RequestService() {
        this.dao = new RequestDAO();
    }

    public void saveDAO(Request request) {
        dao.create(request);
    }

    public Request getRequest(int id) {
        return dao.read(id);
    }

    public List<Request> getListRequest() {
        return dao.readALL();
    }

    public void updateRequest(Request request) {
        dao.update(request);
    }

    public void delete(int id) {
        dao.delete(id);
    }
}
