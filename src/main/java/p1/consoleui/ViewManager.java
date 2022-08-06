package p1.consoleui;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ViewManager {
    private boolean On;
    private static ViewManager viewManager;

    private final Scanner scanner;

    List<View> viewList;
    View nextView;

    private ViewManager() {
        this.On = true;
        this.scanner = new Scanner(System.in);
        viewList = new LinkedList<>();
    }

    public Scanner getScanner() {
        return scanner;
    }

    public static ViewManager getViewManager() {
        if (viewManager == null) {
            viewManager = new ViewManager();
        }
        return viewManager;
    }

    public void navigate(String portal) {
        for (View view : viewList) {
            if (view.viewName.equals(portal)) {
                nextView = view;
            }
        }
    }

    public void registerView(View view) {
        viewList.add(view);
    }

    public void render() {
        nextView.renderView();
    }


    public void quit() {
        On = false;
    }

    public boolean isOn() {
        return On;
    }
}
