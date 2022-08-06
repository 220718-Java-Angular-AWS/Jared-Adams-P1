package p1.consoleui;

import p1.consoleui.View;
import p1.consoleui.ViewManager;
import p1.pojos.User;
import p1.services.UserService;

import java.util.Scanner;

public class UpdateUserMenu extends View {

    public UpdateUserMenu() {
        viewName = "UpdateUser";
        viewManager = ViewManager.getViewManager();
    }


    @Override
    public void renderView() {
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

        viewManager.navigate("MainMenu");
    }
}
