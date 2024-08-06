package clean.architecture.infra.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String name;
    private LocalDate birthDate;
    private String email;

    public UserEntity(String cpf, String name, LocalDate birthDate, String email) {
        this.cpf = cpf;
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
    }
}
