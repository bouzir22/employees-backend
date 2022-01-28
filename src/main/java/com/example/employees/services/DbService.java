package com.example.employees.services;

import com.example.employees.models.Department;
import com.example.employees.models.Employee;
import com.example.employees.models.Role;
import com.example.employees.models.User;
import com.example.employees.repositories.DepartmentRepo;
import com.example.employees.repositories.EmployeeRepo;
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
private EmployeeRepo employeeRepo;
private DepartmentRepo departmentRepo;
     @Autowired
    public DbService(PasswordEncoder passwordEncoder, UserRepo userRepo, RoleRepo roleRepo, EmployeeRepo employeeRepo, DepartmentRepo departmentRepo) {
        this.passwordEncoder = passwordEncoder;
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.employeeRepo = employeeRepo;
        this.departmentRepo = departmentRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        // pass || user
   /*    User user=new User();
      user.setUsername("user");
        user.setPassword(passwordEncoder.encode("user"));
        Role role=new Role();role.setRoleName("ROLE_user");
        user.setRole(roleRepo.save(role));
        userRepo.save(user);*/
/*
Department d =new Department();d.setName("it");
Department d1=new Department();d1.setName("sales");
Employee e=new Employee();
e.setEmail("test@test");
e.setUsername("emp1");
e.setPassword("passE");
e.setDepartment(this.departmentRepo.save(d));
        Employee e1=new Employee();
        e1.setEmail("mail@mail");
        e1.setUsername("emp2");
        e1.setPassword("password");
        e1.setDepartment(this.departmentRepo.save(d1));
this.employeeRepo.save(e1);this.employeeRepo.save(e);
*/


    }
}
