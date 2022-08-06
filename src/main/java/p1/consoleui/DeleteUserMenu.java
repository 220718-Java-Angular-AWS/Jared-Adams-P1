package p1.consoleui;

import p1.services.UserService;

import java.util.Scanner;

public class DeleteUserMenu extends View {

    public DeleteUserMenu() {
        viewName = "DeleteUser";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=============== Cast Them Into The Abyss ===============");
        System.out.print("Enter ID for whom shall be banished...: ");
        Integer id = Integer.parseInt(sc.nextLine());

        UserService delete = new UserService();
        delete.deleteUser(id);

        System.out.println("This User is no more.");

        viewManager.navigate("MainMenu");
    }
}
