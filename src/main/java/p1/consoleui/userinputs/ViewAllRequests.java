package p1.consoleui.userinputs;

import p1.consoleui.View;
import p1.consoleui.ViewManager;
import p1.pojos.Request;
import p1.services.RequestService;

import java.util.List;

public class ViewAllRequests extends View {


    public ViewAllRequests() {
        viewName = "ViewAllRequests";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        System.out.println("========== All Requests ==========");

        RequestService requestService = new RequestService();
        List<Request> listRequests = requestService.getListRequest();

        for(Request r : listRequests) {
            System.out.println(r);
        }

        viewManager.navigate("MainMenu");
    }
}
