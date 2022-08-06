package p1.consoleui.guestinputs;

import p1.consoleui.View;
import p1.consoleui.ViewManager;
import p1.pojos.User;
import p1.services.UserService;

import java.util.Scanner;

public class LogIn extends View{

    public LogIn() {
        viewName = "LogIn";
        viewManager = ViewManager.getViewManager();
    }
    @Override
    public void renderView() {


        Scanner sc = new Scanner(System.in);

        System.out.println("============== Log In ==============");
        System.out.print("Enter Username or Email: ");
        String credentials = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        User logInUser = new User(credentials, password);
        UserService userService = new UserService();
        userService.logInUser(logInUser);



        viewManager.navigate("MainMenu");

        //Make loop if false
    }
}
