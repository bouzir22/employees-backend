package com.example.employees.services;

import com.example.employees.models.Role;
import com.example.employees.models.User;
import com.example.employees.repositories.RoleRepo;
import com.example.employees.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DbService implements CommandLineRunner {
    private PasswordEncoder passwordEncoder;
    private UserRepo userRepo;
    private RoleRepo roleRepo;
    @Autowired
    public DbService(PasswordEncoder passwordEncoder, UserRepo userRepo, RoleRepo roleRepo) {
        this.passwordEncoder = passwordEncoder;
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }



    @Override
    public void run(String... args) throws Exception {
   /*    User user=new User();
      user.setUsername("ahmed");
        user.setPassword(passwordEncoder.encode("pass"));
        Role role=new Role();role.setRoleName("super_admin");
        user.setRole(roleRepo.save(role));
        userRepo.save(user);*/


    }
}
