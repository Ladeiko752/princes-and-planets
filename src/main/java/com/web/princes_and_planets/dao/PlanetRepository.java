package com.web.princes_and_planets.dao;

import com.web.princes_and_planets.entity.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository<Planet, Integer> {
}
