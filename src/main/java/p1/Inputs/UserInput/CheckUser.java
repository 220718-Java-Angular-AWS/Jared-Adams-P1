package p1.Inputs.UserInput;

import p1.pojos.User;
import p1.services.UserService;

import java.util.Scanner;

public class CheckUser {

    public void checkUser() {
        Scanner sc = new Scanner(System.in);

        System.out.println("============= User Lookup =============");
        System.out.print("Enter UserID: ");
        Integer id = Integer.parseInt(sc.nextLine());


        UserService userService = new UserService();
        User user = userService.getUser(id);
        System.out.println(user);
    }

}
