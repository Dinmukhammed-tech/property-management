package io.proglib.mycompany.service;

import io.proglib.mycompany.dto.UserDTO;

public interface UserService {
    UserDTO register(UserDTO userDTO);
    UserDTO login(String emaill, String password);
}
