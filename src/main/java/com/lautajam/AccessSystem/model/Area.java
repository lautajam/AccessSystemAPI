package com.lautajam.AccessSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "areas")
@Getter @Setter
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "area_id")
    private long id;

    @Column(length = 20, nullable = false, unique = true,name = "area_name")
    private String name;

    @Column(length = 15, nullable = false, unique = true, name = "area_telephone")
    private int telephone;

    @Column(length = 50, nullable = false, unique = true, name = "area_email")
    private String email;

    @Column(length = 100, nullable = false, name = "area_description")
    private String description;

    @Column(length = 200, name = "area_roles")
    private String roles;

    @Column(length = 200, name = "area_buildings")
    private String buildings;

    public Area() {
    }

    public Area(String name, int telephone, String email, String description, String roles, String buildings) {
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.description = description;
        this.roles = roles;
        this.buildings = buildings;
    }
}
