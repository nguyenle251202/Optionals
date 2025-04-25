package UI;

import model.Address;
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

        System.out.print("Email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Street: ");
        String street = scanner.nextLine();

        System.out.print("City: ");
        String city = scanner.nextLine();

        System.out.print("ZipCode: ");
        String zipcode = scanner.nextLine();

        System.out.print("Country: ");
        String country = scanner.nextLine();

        System.out.print("PhoneNumber: ");
        String phonenumber = scanner.nextLine().trim();

        return new User(null, username, email, phonenumber, new Address(street, city, zipcode, country));
    }
}
