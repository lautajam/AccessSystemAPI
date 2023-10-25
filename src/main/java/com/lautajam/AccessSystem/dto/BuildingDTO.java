package com.lautajam.AccessSystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class BuildingDTO {
    private long id;
    private String name;
    private String address;
    private List<String> roles;
    private List<String> areas;

    public BuildingDTO(long id, String name, String address, List<String> roles, List<String> areas) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.roles = roles;
        this.areas = areas;
    }
}
