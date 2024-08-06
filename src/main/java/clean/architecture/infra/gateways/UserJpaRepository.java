package clean.architecture.infra.gateways;

import clean.architecture.application.gateways.UserRepository;
import clean.architecture.domain.entities.User;
import clean.architecture.infra.persistence.UserEntity;
import clean.architecture.infra.persistence.UserRepositoryInfra;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserJpaRepository implements UserRepository {
    private final UserRepositoryInfra repository;
    private final UserEntityMapper mapper;

    @Override
    public User saveUser(User user) {
        UserEntity entity = mapper.toEntity(user);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public List<User> listAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }
}
