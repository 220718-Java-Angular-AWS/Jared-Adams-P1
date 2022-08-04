package p1.Inputs.RequestInput;

import p1.pojos.Request;
import p1.services.RequestService;

import java.util.Scanner;

public class UpdateRequest {

    public void updateRequest() {
        Scanner sc = new Scanner(System.in);

        System.out.println("============ Update Your Request ============");
        System.out.print("Enter New Title: ");
        String title = sc.nextLine();
        System.out.print("Enter New Reimbursement Amount: ");
        Float reimbursementAmount = Float.parseFloat(sc.nextLine());
        System.out.print("Enter New Message: ");
        String message = sc.nextLine();
        System.out.print("Enter Request ID: ");
        Integer requestId = Integer.parseInt(sc.nextLine());

        Request updateRequest = new Request(requestId, title, reimbursementAmount, message);
        RequestService requestService = new RequestService();
        requestService.updateRequest(updateRequest);

        System.out.println("Update complete");
    }
}
