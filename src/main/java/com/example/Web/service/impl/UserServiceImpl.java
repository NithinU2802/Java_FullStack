package com.example.Web.service.impl;

import com.example.Web.dto.RegistrationDto;
import com.example.Web.models.Role;
import com.example.Web.models.User;
import com.example.Web.repository.RoleRepository;
import com.example.Web.repository.UserRepository;
import com.example.Web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,RoleRepository roleRepository){
        this.userRepository=userRepository;
        this.roleRepository=roleRepository;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto){
        User user =new User();
        user.setUserName(registrationDto.getUserName());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        Role role = roleRepository.findByName("USER");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }
}
