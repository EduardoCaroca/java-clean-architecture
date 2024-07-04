package clean.architecture.service;

import clean.architecture.model.User;

import java.util.List;

public interface UserService {
    void registerUser(User user);

    List<User> listAll();
}
