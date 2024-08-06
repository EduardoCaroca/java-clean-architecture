package clean.architecture.infra.controller;

import clean.architecture.application.usecases.CreateUser;
import clean.architecture.application.usecases.ListUser;
import clean.architecture.domain.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final CreateUser createUser;
    private final ListUser listUser;

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        User user = createUser.createUser(new User(userDTO.cpf(), userDTO.name(), userDTO.birthDate(), userDTO.email()));
        return new UserDTO(user.getCpf(), user.getName(), user.getBirthDate(), user.getEmail());
    }

    @GetMapping
    public List<UserDTO> listAllUsers() {
        return listUser.listAll().stream().map(user -> new UserDTO(user.getCpf(), user.getName(), user.getBirthDate(), user.getEmail())).toList();
    }
}
