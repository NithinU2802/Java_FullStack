package com.example.Web.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class RegistrationDto {
    private Long id;
    @NotEmpty
    private String userName;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
}
