package p1.consoleui.userinputs;

import p1.consoleui.View;
import p1.consoleui.ViewManager;
import p1.daos.RequestDAO;
import p1.pojos.Request;

import java.util.Scanner;

public class NewRequest extends View {
    public NewRequest() {
        viewName = "NewRequest";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=========== New Request ===========");
        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Reimbursement Amount: ");
        Float reimbursementAmount = Float.parseFloat(sc.nextLine());
        System.out.print("Enter Message: ");
        String message = sc.nextLine();
        System.out.print("Enter UserId: ");
        Integer userId = Integer.parseInt(sc.nextLine());

        Request newRequest = new Request(title, reimbursementAmount, message, userId);
        RequestDAO dao = new RequestDAO();
        dao.create(newRequest);

        System.out.println("Request added");

        viewManager.navigate("MainMenu");
    }
}
