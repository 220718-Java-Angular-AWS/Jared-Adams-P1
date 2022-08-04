package p1.Inputs.RequestInput;

import p1.pojos.Request;
import p1.services.RequestService;

import java.util.List;

public class ViewAllRequests {

    public void viewAllRequests() {

        System.out.println("========== All Requests ==========");

        RequestService requestService = new RequestService();
        List<Request> listRequests = requestService.getListRequest();

        for(Request r : listRequests) {
            System.out.println(r);
        }

    }
}
