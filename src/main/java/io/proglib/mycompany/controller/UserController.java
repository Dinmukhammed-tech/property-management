package io.proglib.mycompany.controller;

import io.proglib.mycompany.dto.UserDTO;
import io.proglib.mycompany.exception.BusinessException;
import io.proglib.mycompany.service.UserService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
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

    @Operation(summary = "register",
            description = "This is for registration",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Успешный ответ"),
                    @ApiResponse(responseCode = "404", description = "Не найдено")
            })
    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@Parameter(description = "UserDTO",required = true)
                                                @Valid @RequestBody UserDTO user) throws BusinessException {
        return new ResponseEntity<>(userService.register(user), HttpStatus.CREATED);
    }
    @PostMapping(path = "/login",consumes = {"application/json"},produces = {"application/json"})
    public ResponseEntity<UserDTO> login(@Valid @RequestBody UserDTO user) throws BusinessException {
        return new ResponseEntity<>(userService.login(user.getOwnerEmail(), user.getPassword()), HttpStatus.OK);
    }
}
