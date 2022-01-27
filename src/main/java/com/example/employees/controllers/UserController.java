package com.example.employees.controllers;

import com.example.employees.services.TokenService;
import com.example.employees.scurity.jwt.JwtLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private TokenService tokenService;
@Autowired
    public UserController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @GetMapping("/test")
    public void test()
    {

        System.out.println("testinvoked");


    }
    @PostMapping("/signin")
            public String login(@RequestBody JwtLogin jwtLogin)
    {
       String token= tokenService.login(jwtLogin);
        System.out.println(token);
        return token;
    }
}
