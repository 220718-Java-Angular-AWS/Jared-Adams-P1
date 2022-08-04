package p1.Inputs.UserInput;

import p1.pojos.User;
import p1.services.UserService;

import java.util.List;

public class CheckAllUsers {

    public void checkAllUsers() {

        System.out.println("============ All Users ============");

        UserService userService = new UserService();
        List<User> userList = userService.getListUsers();

        for(User U : userList) {
            System.out.println(U);
        }

    }
}
