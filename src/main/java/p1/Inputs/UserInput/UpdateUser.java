package p1.Inputs.UserInput;

import p1.pojos.User;
import p1.services.UserService;

import java.util.Scanner;

public class UpdateUser {

    public void updateUser() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=========== Update Existing User ===========");
        System.out.print("Enter New First Name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter New Last Name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter New Email: ");
        String email = sc.nextLine();
        System.out.print("Enter New Username: ");
        String username = sc.nextLine();
        System.out.print("Enter New Password: ");
        String password = sc.nextLine();
        System.out.print("Enter ID Number: ");
        Integer userId = Integer.parseInt(sc.nextLine());

        User updateUser = new User(userId, firstName, lastName, email, username, password);
        UserService userService = new UserService();
        userService.updateUser(updateUser);

        System.out.println("User Updated");
    }
}
