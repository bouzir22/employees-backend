package com.example.employees.controllers;

import com.example.employees.models.Department;
import com.example.employees.repositories.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments/")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartmentController {
    @Autowired
    private DepartmentRepo departmentRepo;
    @GetMapping("all")
    public List<Department>getAll()
    {return this.departmentRepo.findAll();}
}
