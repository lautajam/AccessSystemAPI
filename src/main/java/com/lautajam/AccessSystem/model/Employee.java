package com.lautajam.AccessSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * The Employee class represents an employee in the access system.
 * Each instance of this class corresponds to an employee and stores* Information
 * about the employee's first name, last name, employee number, phone number, ID number,
 * email address, and the role he/she plays in the organization.
 */
@Entity
@Table(name = "employees")
@Getter @Setter
public class Employee {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    @Column(name = "employee_id")
    private long id;

    private String name;

    @Column(length = 20, nullable = false, name = "employee_surname")
    private String surname;

    @Column(nullable = false, name = "employee_number")
    private long employee_number;

    @Column(length = 15, nullable = false, name = "employee_telephone")
    private int telephone;

    @Column(length = 8, nullable = false, name = "employee_dni")
    private int dni;

    @Column(length = 50, nullable = false, unique = true, name = "employee_email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol employee_rol;

    /**
     * Empty constructor for the Employee class.
     */
    public Employee() {
    }

    /**
     * Constructor for the Employee class.
     * @param name The name of the employee.
     * @param surname The surname of the employee.
     * @param employee_number The employee number of the employee.
     * @param telephone The telephone number of the employee.
     * @param dni The ID number of the employee.
     * @param email The e-mail of the employee.
     * @param employee_rol The role of the employee.
     */
    public Employee(String name, String surname, long employee_number, int telephone, int dni, String email, Rol employee_rol) {
        this.name = name;
        this.surname = surname;
        this.employee_number = employee_number;
        this.telephone = telephone;
        this.dni = dni;
        this.email = email;
        this.employee_rol = employee_rol;
    }
}
