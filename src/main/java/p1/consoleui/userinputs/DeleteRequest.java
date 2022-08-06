package p1.consoleui.userinputs;

import p1.consoleui.View;
import p1.consoleui.ViewManager;
import p1.services.RequestService;

import java.util.Scanner;

public class DeleteRequest extends View {

    public DeleteRequest() {
        viewName = "DeleteRequest";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        Scanner sc = new Scanner(System.in);

        System.out.println("============ Delete Request ============");
        System.out.print("Enter Request ID: ");
        Integer id = Integer.parseInt(sc.nextLine());

        RequestService requestService = new RequestService();
        requestService.delete(id);

        System.out.println("Request deleted.");

        viewManager.navigate("MainMenu");
    }
}
