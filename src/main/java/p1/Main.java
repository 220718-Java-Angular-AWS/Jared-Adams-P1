package p1;

import p1.consoleui.*;

import p1.consoleui.guestinputs.GuestMenu;
import p1.consoleui.guestinputs.LogIn;
import p1.consoleui.guestinputs.NewUserMenu;
import p1.consoleui.userinputs.*;
import p1.consoleui.UpdateUserMenu;

public class Main {
    public static void main(String[] args) {


        ViewManager viewManager = ViewManager.getViewManager();
        viewManager.registerView(new MainMenu());
        viewManager.registerView(new NewRequest());
        viewManager.registerView(new UpdateRequest());
        viewManager.registerView(new CheckRequest());
        viewManager.registerView(new ViewAllRequests());
        viewManager.registerView(new DeleteRequest());
        viewManager.registerView(new GuestMenu());
        viewManager.registerView(new LogIn());
        viewManager.registerView(new NewUserMenu());
        viewManager.registerView(new UpdateUserMenu());
        viewManager.registerView(new CheckUserMenu());
        viewManager.registerView(new CheckAllUsersMenu());
        viewManager.registerView(new DeleteUserMenu());

        viewManager.navigate("GuestMenu");

        while (viewManager.isOn()) {
            viewManager.render();
        }
    }
}



