package p1.Inputs.RequestInput;

import p1.pojos.Request;

import p1.services.RequestService;

import java.util.Scanner;

public class CheckRequest {

    public void checkRequest() {
        Scanner sc = new Scanner(System.in);

        System.out.println("============== Which Request Are We Looking For? ==============");
        System.out.print("Enter Request ID Number: ");
        Integer id = Integer.parseInt(sc.nextLine());

        RequestService requestService = new RequestService();
        Request request = requestService.getRequest(id);

        System.out.println(request);
    }
}
