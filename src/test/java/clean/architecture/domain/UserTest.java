package clean.architecture.domain;

import clean.architecture.domain.entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class UserTest {

    @Test
    void shouldNotCreateUserWithInvalidCPF() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("12345678900", "John Doe", LocalDate.parse("1999-01-02"), "teste@teste.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("123456.78900", "John Doe", LocalDate.parse("1999-01-02"), "teste@teste.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("", "John Doe", LocalDate.parse("1999-01-02"), "teste@teste.com"));
    }

    @Test
    void shouldNotAddAddressWithInvalidCEP() {
        UserFactory userFactory = new UserFactory();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> userFactory.addAddress("12345678", 123, "Complement"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> userFactory.addAddress("123.45-678", 123, ""));
    }

    @Test
    void shouldCreateUserWithUserForm() {
        UserFactory userFactory = new UserFactory();
        User user = userFactory.withNameCpfBirthDate("John Doe", "123.456.789-00", LocalDate.parse("1999-01-02"));
        Assertions.assertEquals("John Doe", user.getName());
        Assertions.assertEquals("123.456.789-00", user.getCpf());
        Assertions.assertEquals(LocalDate.parse("1999-01-02"), user.getBirthDate());

        user = userFactory.addAddress("12345-678", 123, "Complement");

        Assertions.assertEquals("12345-678", user.getAddress().cep());
        Assertions.assertEquals(123, user.getAddress().number());
        Assertions.assertEquals("Complement", user.getAddress().complement());
    }
}
