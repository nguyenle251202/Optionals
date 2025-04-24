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
//        Scanner scanner = new Scanner(System.in);
        UserRepository userRepository = new UserRepository();
        User user = menu();
        userRepository.add(user);
    }
    public static User menu() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("UserName: ");
        String username = scanner.nextLine().trim();

        System.out.print("\nEmail: ");
        String email = scanner.nextLine().trim();

        System.out.print("\n PhoneNumber");
        String phonenumber = scanner.nextLine().trim();

        System.out.print("\nStreet: ");
        String street = scanner.nextLine();

        System.out.print("\nCity: ");
        String city = scanner.nextLine();

        System.out.print("\nZipCode: ");
        String zipcode = scanner.nextLine();

        System.out.print("\nCountry: ");
        String country = scanner.nextLine();

        return null;
    }
}
