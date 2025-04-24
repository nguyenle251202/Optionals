package repository;

import model.User;

import java.util.*;
import java.util.stream.Collectors;

public class UserRepository {
    private static final Map<String, User> users = new HashMap<>();

    public static void add(User user) {
        users.put(user.getUsername(), user);
    }

    public static Optional<User> getUserById(String id) {
        return getUserById(id);
    }

    public static Optional<String> getUserCity(String user) {
        return getUserCity(user);
    }

    public static Optional<String> getUserEmailDomain(String user) {
        return getUserEmailDomain(user);
    }

    public static Optional<User> findUserById(String id) {   // findUserById <Optional<User>>
        return users.values().stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public static List<User> findUsersByCity(String city) {
        return users.values().stream().filter(user -> getUserCity(String.valueOf(user))
                        .map(c -> c.equalsIgnoreCase(city)).orElse(false))
                .collect(Collectors.toList());
    }

    public static List<User> findUsersByEmailDomain(String email) {
        return users.values().stream().filter(user -> getUserEmailDomain(String.valueOf(user))
                        .map(d -> d.equals("@gmail.com")).orElse(false))
                .collect(Collectors.toList());
    }

    public Map<String, User> getUsers() {
        return users;
    }
}
