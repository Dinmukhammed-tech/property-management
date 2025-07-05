package io.proglib.mycompany.service;

import io.proglib.mycompany.dto.UserDTO;
import io.proglib.mycompany.exception.BusinessException;

public interface UserService {
    UserDTO register(UserDTO userDTO) throws BusinessException;
    UserDTO login(String emaill, String password) throws BusinessException;
}
