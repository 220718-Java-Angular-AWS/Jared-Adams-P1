package p1.Inputs.UserInput;


import p1.daos.UserDAO;
import p1.pojos.User;
import p1.services.UserService;

import java.util.Scanner;

public class NewUser {
    public void newUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=========== New User ===========");
        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        User newUser = new User(firstName, lastName, email, username, password);
        UserService userService = new UserService();
        userService.saveUser(newUser);

        System.out.println("User added");
    }


}
