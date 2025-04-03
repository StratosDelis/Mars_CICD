package com.seip.Mars_CICD.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String planet_of_origin;

    private double price;

    public Resource() {}

    public Resource(String name, String description, String planet_of_origin, double price) {
        this.name = name;
        this.description = description;
        this.planet_of_origin = planet_of_origin;
        this.price = price;
    }

    //Here start all the Setters and Getters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlanet_of_origin() {
        return planet_of_origin;
    }

    public void setPlanet_of_origin(String planet_of_origin) {
        this.planet_of_origin = planet_of_origin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
