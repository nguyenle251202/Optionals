package UI;

import model.User;
import repository.UserRepository;

import java.util.List;
import java.util.Scanner;

public class FindUsersByEmailDomain {
    public static void findUsersByEmailDomain() {
        System.out.println("Finding users by email domain");
        Scanner scanner = new Scanner(System.in);
        String emailDomain = scanner.nextLine();
        List<User> find = UserRepository.findUsersByEmailDomain(emailDomain);
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
