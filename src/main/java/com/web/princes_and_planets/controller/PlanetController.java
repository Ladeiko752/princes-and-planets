package com.web.princes_and_planets.controller;

import com.web.princes_and_planets.entity.Planet;
import com.web.princes_and_planets.entity.Prince;
import com.web.princes_and_planets.service.implementation.PlanetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class PlanetController {
    private final PlanetServiceImpl planetService;

    @Autowired
    public PlanetController(PlanetServiceImpl planetService) {
        this.planetService = planetService;
    }

    @GetMapping("/planets")
    public List<Planet> getListOfPlanets(){
        return planetService.getAllPlanets();
    }

    @GetMapping("/planets/{id}")
    public Planet getPlanetOnId(@PathVariable int id) throws Exception {
        return planetService.getPlanetOnId(id);
    }

    @PostMapping("/planets")
    public Planet addPlanet(@RequestBody Planet planet){
        planetService.savePlanet(planet);
        return planet;
    }

    @DeleteMapping("/planets/{id}")
    public String deletePlanet(@PathVariable int id) throws Exception {
        planetService.deletePlanet(id);
        return "Planet with ID = " + id + " was deleted";
    }

    @PostMapping("/planets/{id}")
    public Planet entrustControlPlanet(@PathVariable int id, @RequestBody Prince prince) throws Exception {
        Planet planet = planetService.entrustManagement(id, prince);
        planetService.savePlanet(planet);
        return planet;
    }

}
