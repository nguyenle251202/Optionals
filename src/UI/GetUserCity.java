package UI;

import repository.UserRepository;

import java.util.Scanner;

public class GetUserCity {
    public static void getUserByCity() {
        System.out.print("----- Get Users City -----");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID: ");
        String id = scanner.nextLine();
//        UserRepository userRepository = new UserRepository();
//        userRepository.getUserCity(id)
        UserRepository.getUserCity(id)
                .flatMap(UserRepository::getUserCity)
                .ifPresentOrElse(city -> System.out.println("City: " + city),
                        () -> System.out.println("Cannot get user city"));
    }
}
