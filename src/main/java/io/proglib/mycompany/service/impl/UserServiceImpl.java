package io.proglib.mycompany.service.impl;

import io.proglib.mycompany.converter.UserConverter;
import io.proglib.mycompany.dto.UserDTO;
import io.proglib.mycompany.entity.UserEntity;
import io.proglib.mycompany.repository.UserRepository;
import io.proglib.mycompany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {
        UserEntity entity = userRepository.save(userConverter.convertDTOToEntity(userDTO));
        return userConverter.convertEntityToDTO(entity);
    }

    @Override
    public UserDTO login(String emaill, String password) {
        return null;
    }
}
