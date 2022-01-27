package com.example.employees.scurity.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.employees.models.User;
import com.example.employees.repositories.UserRepo;
import com.example.employees.scurity.UserPrincipal;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
private UserRepo userRepo;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UserRepo userRepo) {
        super(authenticationManager);
        this.userRepo = userRepo;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String header =request.getHeader(JwtProperties.HEADER_STRING);
        if(header==null || !header.startsWith(JwtProperties.TOKEN_PREFIX)){
            System.out.println("making tests"); chain.doFilter(request,response); return;}
        System.out.println("testing");
    Authentication authentication=getUsernamePasswordAuthentification(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request,response);
    }
    private Authentication getUsernamePasswordAuthentification(HttpServletRequest request){
        System.out.println("filter invoked");
        String token=request.getHeader(JwtProperties.HEADER_STRING)  .replace(JwtProperties.TOKEN_PREFIX,"");
if(token!=null){String userName= JWT.require(Algorithm.HMAC512(JwtProperties.Secret.getBytes(StandardCharsets.UTF_8))).build().verify(token).getSubject();
    if(userName!=null){

        User user = userRepo.findByUsername(userName);
        UserPrincipal userPrincipal=new UserPrincipal(user);
        UsernamePasswordAuthenticationToken auth =new UsernamePasswordAuthenticationToken(userName,null,userPrincipal.getAuthorities());
                return auth;

    }return null;

}return null;
    }
}
