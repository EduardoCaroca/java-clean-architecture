package clean.architecture.application.usecases;

import clean.architecture.application.gateways.UserRepository;
import clean.architecture.domain.entities.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateUser {
    private final UserRepository repository;

    public User createUser(User user) {
        return repository.saveUser(user);
    }
}
