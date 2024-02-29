package com.SecurityLoginWithDatabase.controller;

import com.SecurityLoginWithDatabase.entity.User;
import com.SecurityLoginWithDatabase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class LoginController {

    @GetMapping("/welcome")
    public String getWelcome(){
        return "welcome";
    }
    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }


}
