package io.proglib.mycompany.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    private Long id;
    private String ownerName;
    @NotNull(message = "Owner Email is mandatory")
    @NotEmpty(message="Owner Email can not be empty")
    @Size(min=1,max = 50,message="Owner Email should be between 1 to 50 chars in length")
    private String ownerEmail;
    private String phoneNumber;
    @NotNull(message="Password can not be null")
    @NotEmpty(message="Password can not be empty")
    private String password;
}
