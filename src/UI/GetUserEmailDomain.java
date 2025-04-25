package UI;

import repository.UserRepository;

import java.util.Scanner;

public class GetUserEmailDomain {
    public static void getUserEmailDomain() {
        System.out.print("----- Get User Email -----");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID: ");
        String id = scanner.nextLine();
//        UserRepository userRepository = new UserRepository();
//        userRepository.getUserEmailDomain(id)
        UserRepository.findUserById(id)
                .flatMap(UserRepository::getUserEmailDomain)
                .ifPresentOrElse(email ->
                                System.out.print("emailDomain: " + email),
                        () -> System.out.println("User not found or email invalid"));
    }
}
