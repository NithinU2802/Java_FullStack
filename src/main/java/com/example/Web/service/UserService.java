package com.example.Web.service;

import com.example.Web.dto.RegistrationDto;
import com.example.Web.models.User;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    User findByEmail(String email);

    User findByName(String userName);
}
