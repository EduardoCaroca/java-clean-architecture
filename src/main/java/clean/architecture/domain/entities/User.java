package clean.architecture.domain.entities;

import clean.architecture.domain.valueobject.Address;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class User {
    private final String cpf;
    private final String name;
    private final LocalDate birthDate;
    private final String email;
    private Address address;

    public User(String cpf, String name, LocalDate birthDate, String email) {
        if (cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            throw new IllegalArgumentException("Invalid CPF");
        }

        this.cpf = cpf;
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
    }

}
