package com.example.employees.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.employees.scurity.UserPrincipal;
import com.example.employees.scurity.jwt.JwtLogin;
import com.example.employees.scurity.jwt.JwtProperties;
import com.example.employees.scurity.jwt.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
    private AuthenticationManager authenticationManager;
        @Autowired
    public TokenService(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    private String generateToken(Authentication authResult)
    {

        UserPrincipal userPrincipal=(UserPrincipal) authResult.getPrincipal();
        System.out.println(userPrincipal.getUsername());
        String token = JWT.create().withSubject(userPrincipal.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+ JwtProperties.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(JwtProperties.Secret.getBytes()));
        return token;
    }
    public LoginResponse login(JwtLogin jwtLogin){

        System.out.println(jwtLogin.getPassword()+ jwtLogin.getUsername());
        Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtLogin.getUsername(),jwtLogin.getPassword()));
       /*     System.out.println(authentication);
            System.out.println(authentication.isAuthenticated());*/
        //System.out.println("test");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token =generateToken(authentication);
        //   System.out.println(token);
        return new LoginResponse(jwtLogin.getUsername(),token);

    }
}
