package com.web.princes_and_planets.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "planet")
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "planet_name")
    private String planetName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prince_id")
    @JsonIgnoreProperties({"planets"})  // can ignore specific fields at the class level
    private Prince prince;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public Prince getPrince() {
        return prince;
    }

    public void setPrince(Prince prince) {
        this.prince = prince;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return id == planet.id && Objects.equals(planetName, planet.planetName) && Objects.equals(prince, planet.prince);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, planetName, prince);
    }
}
