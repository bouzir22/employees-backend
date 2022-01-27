package com.example.employees.models;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private String isername;
    private String email;
    private String password;
    @ManyToOne
    private Department department;

}
