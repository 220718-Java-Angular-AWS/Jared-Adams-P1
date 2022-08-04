package p1.Inputs.RequestInput;

import p1.services.RequestService;

import java.util.Scanner;

public class DeleteRequest {

    public void deleteRequest(){
        Scanner sc = new Scanner(System.in);

        System.out.println("============ Delete Request ============");
        System.out.print("Enter Request ID: ");
        Integer id = Integer.parseInt(sc.nextLine());

        RequestService requestService = new RequestService();
        requestService.delete(id);

        System.out.println("Request deleted.");
    }
}
