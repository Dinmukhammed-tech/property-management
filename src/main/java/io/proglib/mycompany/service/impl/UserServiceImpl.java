package io.proglib.mycompany.service.impl;

import io.proglib.mycompany.converter.UserConverter;
import io.proglib.mycompany.dto.UserDTO;
import io.proglib.mycompany.entity.UserEntity;
import io.proglib.mycompany.exception.BusinessException;
import io.proglib.mycompany.exception.ErrorModel;
import io.proglib.mycompany.repository.UserRepository;
import io.proglib.mycompany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) throws BusinessException {
        if(userRepository.findByOwnerEmail(userDTO.getOwnerEmail()).isPresent()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("EMAIL_ALREADY_EXIST");
            errorModel.setMessage("The email with which you trying to register already exists");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }
        UserEntity entity = userRepository.save(userConverter.convertDTOToEntity(userDTO));
        return userConverter.convertEntityToDTO(entity);
    }

    @Override
    public UserDTO login(String email, String password) throws BusinessException {
        UserDTO userDTO = null;
        Optional<UserEntity> optEn = userRepository.findByOwnerEmailAndPassword(email, password);

        if(optEn.isPresent()) {
            userDTO = userConverter.convertEntityToDTO(optEn.get());
        }else{
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("INVALID_LOGIN");
            errorModel.setMessage("Invalid username or password");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }

        return userDTO;
    }
}
