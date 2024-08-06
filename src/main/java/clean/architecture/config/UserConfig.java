package clean.architecture.config;

import clean.architecture.application.gateways.UserRepository;
import clean.architecture.application.usecases.CreateUser;
import clean.architecture.application.usecases.ListUser;
import clean.architecture.infra.gateways.UserEntityMapper;
import clean.architecture.infra.gateways.UserJpaRepository;
import clean.architecture.infra.persistence.UserRepositoryInfra;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    CreateUser createUser(UserRepository userRepository) {
        return new CreateUser(userRepository);
    }

    @Bean
    UserJpaRepository createUserJpaRepository(UserRepositoryInfra repository, UserEntityMapper mapper) {
        return new UserJpaRepository(repository, mapper);
    }

    @Bean
    UserEntityMapper createUserEntityMapper() {
        return new UserEntityMapper();
    }

    @Bean
    ListUser listUser(UserRepository userRepository) {
        return new ListUser(userRepository);
    }

}
