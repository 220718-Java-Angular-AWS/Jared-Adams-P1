package p1.consoleui.userinputs;

import p1.consoleui.View;
import p1.consoleui.ViewManager;
import p1.pojos.Request;

import p1.services.RequestService;

import java.util.Scanner;

public class CheckRequest extends View {

    public CheckRequest() {
        viewName = "CheckRequest";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        Scanner sc = new Scanner(System.in);

        System.out.println("============== Which Request Are We Looking For? ==============");
        System.out.print("Enter Request ID Number: ");
        Integer id = Integer.parseInt(sc.nextLine());

        RequestService requestService = new RequestService();
        Request request = requestService.getRequest(id);

        System.out.println(request);

        viewManager.navigate("MainMenu");
    }
}
