package clean.architecture.infra.controller;

import java.time.LocalDate;

public record UserDTO(
        String cpf,
        String name,
        LocalDate birthDate,
        String email) {
}
