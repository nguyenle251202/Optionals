package UI;

import model.User;
import repository.UserRepository;

import java.util.Scanner;

public class GetUserCity {
    public static void getUserByCity() {
        System.out.print("----- Get Users City -----");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID: ");
        String id = scanner.nextLine();
        UserRepository.findUserById(id).flatMap(UserRepository::getUserCity)
                .ifPresentOrElse(city -> System.out.print("City: " + city),
                        () -> System.out.println("User not found"));
    }
}
