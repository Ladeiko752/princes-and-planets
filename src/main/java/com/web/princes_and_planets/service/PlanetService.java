package com.web.princes_and_planets.service;

import com.web.princes_and_planets.entity.Planet;
import com.web.princes_and_planets.entity.Prince;

import java.util.List;

public interface PlanetService {
    public List<Planet> getAllPlanets();
    public Planet getPlanetOnId(int id) throws Exception;
    public void deletePlanet(int id) throws Exception;
    public void savePlanet(Planet planet);
    public Planet entrustManagement(int id, Prince prince) throws Exception;
}
