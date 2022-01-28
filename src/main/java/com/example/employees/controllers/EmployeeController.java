package com.example.employees.controllers;

import com.example.employees.models.Employee;
import com.example.employees.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/employee/")
public class EmployeeController {

    private EmployeeService employeeService;
       @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

   @GetMapping("all")
   public List<Employee>getAll(){
       System.out.println("invoked");
           return this.employeeService.getAll();}
    @PostMapping("add/{idDep}")
    public void addEmployee(@RequestBody Employee e,@PathVariable Long idDep)
    {this.employeeService.addEmployee(e,idDep);}
    @PutMapping("edit/{idDep}")
    public void EditEmployee(@RequestBody Employee e,@PathVariable Long idDep)
    {this.employeeService.editEmployee(e,idDep);}
    @DeleteMapping("delete/{id}")
    public void deleteEmployee(@PathVariable Long id){


           this.employeeService.deleteEmployee(id);}
    @GetMapping("findOne/{id}")
    public Employee getOne(@PathVariable Long id)
    {return this.employeeService.getOne(id);}
}
