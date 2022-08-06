package p1.consoleui.guestinputs;

import p1.consoleui.View;
import p1.consoleui.ViewManager;

import java.util.Scanner;

public class GuestMenu extends View {

    public GuestMenu() {
        viewName = "GuestMenu";
        viewManager = ViewManager.getViewManager();
    }


    @Override
    public void renderView() {
        Scanner sc = new Scanner(System.in);

        System.out.println("============== Guest Menu ==============");
        System.out.println("E) Existing User \nN) New User");
        System.out.println();
        System.out.println("Choose your path: ");
        String input = sc.nextLine();

        switch (input) {
            case "E":
                System.out.println("Loading...");
                viewManager.navigate("LogIn");
                break;
            case "N":
                System.out.println("Preparing character creation...");
                viewManager.navigate("NewUser");
        }
    }
}
