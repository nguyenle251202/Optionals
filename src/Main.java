import UI.*;
import enums.Enum;

import java.util.Scanner;

public class Main {
    public static void displayMenu() {
        System.out.println("");
        System.out.println("----- Menu -----");
        System.out.println("[1]. AddUser");
        System.out.println("[2]. ViewAll");
        System.out.println("[3]. FindUserById");
        System.out.println("[4]. FindUsersByCity");
        System.out.println("[5]. FindUsersByEmailDomain");
        System.out.println("[0]. Exit");
    }
    public static Enum.Option OptionMenu(int numberOption) {
        Enum.Option option = Enum.Option.fromCode(numberOption);

        if (option == null) {
            System.out.println("Invalid option");
            return option;
        }
        switch (option) {
            case AddUser:
                System.out.println("Add User");
                AddUser.addUser();
                break;
            case ViewAll:
                System.out.println("View All");
                ViewAll.viewAll();
                break;
            case FindUserById:
                System.out.println("Find User By Id");
                FindUserById.findUserById();
                break;
            case GetUserEmailDomain:
                System.out.println("Get User Email Domain");
                GetUserEmailDomain.getUserEmailDomain();
                break;
            case GetUserCity:
                System.out.println("Get User City");
                GetUserCity.getUserByCity();
                break;
            case FindUsersByCity:
                System.out.println("Find Users By City");
                FindUsersByCity.findUsersByCity();
                break;
            case FindUsersByEmailDomain:
                System.out.println("Find Users By Email Domain");
                FindUsersByEmailDomain.findUsersByEmailDomain();
                break;
            case EXIT:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
        return option;
    }
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        Enum.Option chosenOption;
        do {
            displayMenu();
            System.out.print("Enter your option (0-7): ");
            int input = -1;
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 0 and 7.");
                scanner.next();
                System.out.print("Enter your option (0-7): ");
            }
            input = scanner.nextInt();
            scanner.nextLine();
            chosenOption = OptionMenu(input);
        } while (chosenOption != Enum.Option.EXIT);
        scanner.close();
        System.out.println("Application finished.");
    }
    public static void main(String[] args) {
        menu();
    }
}