package com.lautajam.AccessSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class SimpleTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String attribute1;

    private int attribute2;

    private double attribute3;

    private boolean attribute4;

    public SimpleTest() {
    }

    public SimpleTest(String attribute1, int attribute2, double attribute3, boolean attribute4) {
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
        this.attribute3 = attribute3;
        this.attribute4 = attribute4;
    }
}

