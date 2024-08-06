package clean.architecture.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryInfra extends JpaRepository<UserEntity, Long> {
}
