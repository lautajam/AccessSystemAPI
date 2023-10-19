package com.lautajam.AccessSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * The class Role represents a role within an organization or access system.
 * Each instance of this class corresponds to a role and stores information about its name,
 * description, salary, the employees that perform that role, the related areas and
 * the associated buildings, description, salary, the employees that perform that role,
 * the related areas and the associated buildings.
*/
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

   @ManyToMany(mappedBy = "roles")
    private List<Area> areas;

    @ManyToMany(mappedBy = "roles")
    private List<Building> buildings;

    /**
     * Empty constructor for Rol class.
     */
    public Rol() {
    }

    /**
     * Constructor for Rol class.
     * @param id The id of the role.
     * @param name The name of the role.
     * @param description The description of the role.
     * @param salary The salary of the role.
     * @param employees The employees that perform the role.
     * @param areas The list of areas related to the role.
     * @param buildings The list of buildings related to the role.
     */
    public Rol(long id, String name, String description, double salary,
               List<Employee> employees, List<Area> areas, List<Building> buildings) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.salary = salary;
        this.employees = employees;
        this.areas = areas;
        this.buildings = buildings;
    }
}
