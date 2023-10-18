package com.lautajam.AccessSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "roles")
@Getter @Setter
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "rol_id")
    private long id;

    @Column(length = 20, nullable = false, unique = true, name = "rol_name")
    private String name;

    @Column(length = 100, name = "rol_description")
    private String description;

    @Column(name = "rol_salary")
    private double salary;

    @OneToMany(mappedBy = "employee_rol")
    private List<Employee> employees;

    @Column(length = 200, name = "rol_areas")
    private String areas;

    @Column(length = 200, name = "rol_buildings")
    private String buildings;

    public Rol() {
    }

    public Rol(long id, String name, String description, double salary, List<Employee> employees, String areas, String buildings) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.salary = salary;
        this.employees = employees;
        this.areas = areas;
        this.buildings = buildings;
    }
}
