package clean.architecture.application.gateways;

import clean.architecture.domain.entities.User;

import java.util.List;

public interface UserRepository {

    User saveUser(User user);

    List<User> listAll();
}
