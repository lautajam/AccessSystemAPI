package com.lautajam.AccessSystem.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * The class Area represents an area in the company (administrative, technological, etc.).
 * Each instance of this class corresponds to an area and stores information about its name,
 * telephone, e-mail, description, the roles that exist within the area and the buildings
 * where it is located,
 */
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

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @ManyToMany
    @JoinTable(
            name = "area_roles",
            joinColumns = @JoinColumn(name = "area_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Rol> roles;

    @ManyToMany(mappedBy = "areas")
    private List<Building> buildings;

    /*
     * Empty constructor for the Area class.
     */
    public Area() {
    }

    /**
     * Constructor for the Area class.
     * @param name The name of the area.
     * @param telephone The telephone number of the area.
     * @param email The e-mail of the area.
     * @param description The description of the area.
     * @param roles The list of roles associated with the area.
     * @param buildings The list of buildings where the area is located.
     */
    public Area(long id, String name, int telephone, String email, String description,
                List<Rol> roles, List<Building> buildings) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.description = description;
        this.roles = roles;
        this.buildings = buildings;
    }
}
