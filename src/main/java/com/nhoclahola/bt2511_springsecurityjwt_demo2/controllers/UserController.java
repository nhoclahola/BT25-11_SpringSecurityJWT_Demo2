package com.nhoclahola.bt2511_springsecurityjwt_demo2.controllers;

import com.nhoclahola.bt2511_springsecurityjwt_demo2.entities.UserInfo;
import com.nhoclahola.bt2511_springsecurityjwt_demo2.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController
{
    private final UserService userService;

    @PostMapping("/new")
    public String addUser(@RequestBody UserInfo userInfo)
    {
        return userService.addUser(userInfo);
    }
}
