package io.proglib.mycompany.controller;

import io.proglib.mycompany.dto.UserDTO;
import io.proglib.mycompany.exception.BusinessException;
import io.proglib.mycompany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO user) throws BusinessException {
        return new ResponseEntity<>(userService.register(user), HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO user) throws BusinessException {
        return new ResponseEntity<>(userService.login(user.getOwnerEmail(), user.getPassword()), HttpStatus.OK);
    }
}
