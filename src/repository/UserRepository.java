package repository;

import model.Address;
import model.User;

import java.util.*;
import java.util.stream.Collectors;

public class UserRepository {
    private static final Map<String, User> users = new HashMap<>();

    public static void add(User user) {
        users.put(user.getUsername(), user);
    }

    public static Optional<User> getUserById(String id) {
        return findUserById(id);
    }

    public static Optional<String> getUserCity(User user) {
        return user.getAddress().map(Address::getCity); 
    }

    public static Optional<String> getUserEmailDomain(User user) {
        return Optional.ofNullable(user.getEmail())
                .filter(email -> email.contains("@"))
                .map(email -> email.substring(email.indexOf("@") + 1));
    }

    public static Optional<User> findUserById(String id) {   // findUserById <Optional<User>>
        return users.values().stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public static List<User> findUsersByCity(String city) {
        return users.values().stream().filter(user -> getUserCity(user)
                        .map(c -> c.equalsIgnoreCase(city)).orElse(false))
                .collect(Collectors.toList());
    }

    public static List<User> findUsersByEmailDomain(String email) {
        return users.values().stream().filter(user -> getUserEmailDomain(user)
                        .map(d -> d.equalsIgnoreCase(email)).orElse(false))
                .collect(Collectors.toList());
    }

    public Map<String, User> getUsers() {
        return users;
    }
}
