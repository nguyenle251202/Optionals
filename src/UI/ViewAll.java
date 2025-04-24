package UI;

import model.User;
import repository.UserRepository;

import java.util.Map;

public class ViewAll {
    public static void viewAll() {
        System.out.println("Viewing all users");
        UserRepository userRepository = new UserRepository();
        Map<String, User> users = userRepository.getUsers();
        for (User user : users.values()) {
            System.out.println(user);
        }
    }
}
