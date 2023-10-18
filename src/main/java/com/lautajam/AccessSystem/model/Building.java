package com.lautajam.AccessSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "buildings")
@Getter @Setter
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "building_id")
    private long id;

    @Column(length = 20, nullable = false, name = "building_name")
    private String name;

    @Column(length = 40, nullable = false, name = "building_address")
    private String address;

    @Column(length = 200, name = "building_areas")
    private String areas;

    @Column(length = 200, name = "building_roles")
    private String roles;

    public Building() {
    }

    public Building(String name, String address, String areas, String roles) {
        this.name = name;
        this.address = address;
        this.areas = areas;
        this.roles = roles;
    }
}
