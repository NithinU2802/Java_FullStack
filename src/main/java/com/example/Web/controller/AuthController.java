package com.example.Web.controller;

import com.example.Web.dto.RegistrationDto;
import com.example.Web.models.User;
import com.example.Web.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private UserService userService;

    public AuthController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterForm(Model model){
        RegistrationDto user =new RegistrationDto();
        model.addAttribute("user",user);
        return "register";
    }

    @PostMapping("register/save")
    public String register(@Valid @ModelAttribute("user") RegistrationDto user, BindingResult result, Model model){
        User exUserEmail = userService.findByEmail(user.getEmail());
        if(exUserEmail!=null && exUserEmail.getEmail()!=null && !exUserEmail.getEmail().isEmpty())
            return "redirect:/register?fail";
        User exUserName=userService.findByName(user.getUserName());
        if(exUserName!=null && exUserName.getUserName()!=null && !exUserName.getUserName().isEmpty())
            return "redirect:/register?fail";
        if(result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/clubs?success";
    }

}
