package UI;

import model.User;
import repository.UserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddUser {
    public static void addUser() {
        Map<String, User> users = new HashMap<String, User>();
        System.out.println("----- Add User -----");
        Scanner scanner = new Scanner(System.in);
        UserRepository userRepository = new UserRepository();

    }
}
