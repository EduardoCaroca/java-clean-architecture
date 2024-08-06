package clean.architecture.domain;

import clean.architecture.domain.entities.User;
import clean.architecture.domain.valueobject.Address;

import java.time.LocalDate;

public class UserFactory {
    private User user;

    public User withNameCpfBirthDate(String name, String cpf, LocalDate birthDate) {
        user = new User(cpf, name, birthDate, "");
        return user;
    }

    public User addAddress(String cep, Integer number, String complement) {
        user.setAddress(new Address(cep, number, complement));
        return user;
    }
}
