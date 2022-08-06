package p1.consoleui.userinputs;

import p1.consoleui.View;
import p1.consoleui.ViewManager;

import java.util.Scanner;

public class MainMenu extends View {

    public MainMenu() {
        viewName = "MainMenu";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=============== Main Menu ===============");
        System.out.println("======== Select Your Destination ========");
        System.out.println("N) New Request\nU) Update Request\nC) Check Request\nV) View All Requests\nD) Delete Request\nQ) Quit");
        System.out.println();
        System.out.print("Go ahead, pick: ");
        String input = sc.nextLine();

        switch (input) {
            case "N":
                System.out.println();
                viewManager.navigate("NewRequest");
                break;
            case "U":
                //System.out.println("Everyone makes mistakes, luckily you can fix yours");
                System.out.println();
                viewManager.navigate("UpdateRequest");
                break;
            case "C":
                //System.out.println("Don't tell anyone we're giving out information");
                System.out.println();
                viewManager.navigate("CheckRequest");
                break;
            case "V":
                //System.out.println("Seems a bit nosey, but if you insist...");
                System.out.println();
                viewManager.navigate("ViewAllRequests");
                break;
            case "D":
                //System.out.println("SAY HELLO TO MY LITTLE FRIEND");
                System.out.println();
                viewManager.navigate("DeleteRequest");
                break;
            case "Q":
                System.out.println("Sayonara");
                viewManager.quit();
                break;
            default:
                System.out.println("Please abide by the rules and enter a valid option");
                break;

        }
    }
}

