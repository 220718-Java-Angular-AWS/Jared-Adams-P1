package p1.consoleui;

import p1.pojos.User;
import p1.services.UserService;

import java.util.List;

public class CheckAllUsersMenu extends View{

    public CheckAllUsersMenu() {
        viewName = "CheckAllUsers";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        System.out.println("============ All Users ============");

        UserService userService = new UserService();
        List<User> userList = userService.getListUsers();

        for(User U : userList) {
            System.out.println(U);
        }

        viewManager.navigate("MainMenu");
    }
}
