package com.example.employees.repositories;

import com.example.employees.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmployeeRepo extends JpaRepository<Employee,Long> {
}
