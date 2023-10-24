package com.lautajam.AccessSystem.dto;

import com.lautajam.AccessSystem.model.Building;
import com.lautajam.AccessSystem.model.Rol;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter @Setter
public class AreaDTO implements Serializable {
        private long id;
        private String name;
        private int telephone;
        private String email;
        private String description;
        private List<String> roles;
        private List<String> buildings;

        public AreaDTO(long id, String name, int telephone, String email, String description, List<String> roles, List<String> buildings) {
            this.id = id;
            this.name = name;
            this.telephone = telephone;
            this.email = email;
            this.description = description;
            this.roles = roles;
            this.buildings = buildings;
        }
}
