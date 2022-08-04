package p1.Inputs.UserInput;

import p1.services.UserService;

import java.util.Scanner;

public class DeleteUser {

    public void deleteUser() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=============== Cast Them Into The Abyss ===============");
        System.out.print("Enter ID for whom shall be banished...: ");
        Integer id = Integer.parseInt(sc.nextLine());

        UserService delete = new UserService();
        delete.deleteUser(id);

        System.out.println("This User is no more.");
    }
}
