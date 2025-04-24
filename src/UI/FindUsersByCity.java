package UI;

import model.User;
import repository.UserRepository;

import java.util.List;
import java.util.Scanner;

public class FindUsersByCity {
    public static void findUsersByCity() {
        System.out.println("Finding users by city");
        Scanner scanner = new Scanner(System.in);
        String city = scanner.nextLine();
        List<User> find = UserRepository.findUsersByCity(city);
        if (find.isEmpty()) {
            System.out.println("No users found");
        } else {
            System.out.println("Found " + find.size() + " users");
            for (User user : find) {
                System.out.println(user);
            }
        }
    }
}
