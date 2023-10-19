package com.lautajam.AccessSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * The Building class represents a building in the access system.
 * Each instance of this class corresponds to a building and stores information
 * about its name, address and associated areas and roles. information about its name,
 * address and associated areas and roles.
 */
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

    /**
     * Empty constructor for the Building class.
     */
    public Building() {
    }

    /**
     * Constructor for the Building class.
     * @param name The name of the building.
     * @param address The address of the building.
     * @param areas The list of areas associated with the building.
     * @param roles The list of roles associated with the building.
     */
    public Building(String name, String address, List<Area> areas, List<Rol> roles) {
        this.name = name;
        this.address = address;
        this.areas = areas;
        this.roles = roles;
    }
}
