package UI;

import repository.UserRepository;
import service.UserService;

import java.util.Scanner;

public class FindUserById {
    public static void findUserById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- Find User By Id -----");
        System.out.println("Enter Id: ");
        String id = scanner.nextLine();
        UserRepository userRepository = new UserRepository();
        userRepository.getUserById(id).ifPresentOrElse
                (user -> System.out.println("Found: " + user),
                () -> System.out.println("User not found."));
    }
}
