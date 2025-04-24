package service;

import model.User;
import repository.UserRepository;

import java.util.Optional;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // return Optional<User>
    public Optional<User> getUserById(String id) {
        return userRepository.findUserById(id);
    }

    // return Optional<String>
    public Optional<String> getUserCity(User user) {
        return userRepository.getUserCity(user);
    }

    public Optional<String> getUserEmailDomain(User user) {
        return userRepository.getUserEmailDomain(user);
    }
}
