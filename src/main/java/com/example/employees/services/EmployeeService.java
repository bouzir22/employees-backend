package com.example.employees.services;

import com.example.employees.models.Department;
import com.example.employees.models.Employee;
import com.example.employees.repositories.DepartmentRepo;
import com.example.employees.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
private EmployeeRepo employeeRepo;
private DepartmentRepo departmentRepo;
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo, DepartmentRepo departmentRepo) {
        this.employeeRepo = employeeRepo;
        this.departmentRepo = departmentRepo;
    }



  public void addEmployee(Employee e,Long idDep)
  {if(e!=null)
  { Optional<Department> d=this.departmentRepo.findById(idDep);
      if(d.isPresent()){e.setDepartment(d.get());this.employeeRepo.save(e);}
  }
     }
  public void editEmployee(Employee e,Long idDep)
  {if(e!=null) {

      Optional<Department> d=this.departmentRepo.findById(idDep);
      if(d.isPresent()){e.setDepartment(d.get());this.employeeRepo.save(e);}
  }
  }
  public void deleteEmployee(Long id)
  {this.employeeRepo.deleteById(id);}
  public List<Employee> getAll()
  {return  this.employeeRepo.findAll();}
  public Employee getOne(Long id)
  {
      Optional<Employee> e=this.employeeRepo.findById(id);
      if (e.isPresent())return e.get(); return null;
  }


}
