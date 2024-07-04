package clean.architecture.service;

import clean.architecture.model.User;
import clean.architecture.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public void registerUser(User user) {
        repository.save(user);
    }

    @Override
    public List<User> listAll() {
        return repository.findAll();
    }
}
