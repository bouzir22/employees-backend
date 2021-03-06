package com.example.employees.services;

import com.example.employees.models.User;
import com.example.employees.repositories.UserRepo;
import com.example.employees.scurity.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     User user=repo.findByUsername(username);
        UserPrincipal userPrincipal=new UserPrincipal(user);
        return userPrincipal;
    }


}
