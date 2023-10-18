package com.lautajam.AccessSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    @ManyToMany
    @JoinTable(
        name = "building_areas",
        joinColumns = @JoinColumn(name = "building_id"),
        inverseJoinColumns = @JoinColumn(name = "area_id")
    )
    private List<Area> areas;

    @ManyToMany
    @JoinTable(
            name = "building_roles",
            joinColumns = @JoinColumn(name = "building_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Rol> roles;

    public Building() {
    }

    public Building(String name, String address, List<Area> areas, List<Rol> roles) {
        this.name = name;
        this.address = address;
        this.areas = areas;
        this.roles = roles;
    }
}
