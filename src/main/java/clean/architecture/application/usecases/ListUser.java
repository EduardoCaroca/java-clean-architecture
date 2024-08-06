package clean.architecture.application.usecases;

import clean.architecture.application.gateways.UserRepository;
import clean.architecture.domain.entities.User;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListUser {
    private final UserRepository repository;

    public List<User> listAll() {
        return repository.listAll();
    }
}
