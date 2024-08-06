package clean.architecture.infra.gateways;

import clean.architecture.domain.entities.User;
import clean.architecture.infra.persistence.UserEntity;

public class UserEntityMapper {

    public UserEntity toEntity(User user) {
        return new UserEntity(user.getCpf(), user.getName(), user.getBirthDate(), user.getEmail());
    }

    public User toDomain(UserEntity userEntity) {
        return new User(userEntity.getCpf(), userEntity.getName(), userEntity.getBirthDate(), userEntity.getEmail());
    }
}
