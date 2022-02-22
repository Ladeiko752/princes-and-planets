package com.web.princes_and_planets.service.implementation;

import com.web.princes_and_planets.dao.PlanetRepository;
import com.web.princes_and_planets.dao.PrinceRepository;
import com.web.princes_and_planets.entity.Planet;
import com.web.princes_and_planets.entity.Prince;
import com.web.princes_and_planets.exam.Check;
import com.web.princes_and_planets.exception.NotFoundObjectException;
import com.web.princes_and_planets.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetServiceImpl implements PlanetService {
    private final PlanetRepository planetRepository;
    private final Check check;

    @Autowired
    public PlanetServiceImpl(PlanetRepository planetRepository, PrinceRepository princeRepository, Check check) {
        this.planetRepository = planetRepository;
        this.check = check;
    }

    @Override
    public List<Planet> getAllPlanets() {
        return planetRepository.findAll();
    }

    @Override
    public Planet getPlanetOnId(int id) throws Exception {
        Planet planet = null;
        Optional<Planet> optional = planetRepository.findById(id);
        if (optional.isPresent()){
            planet = optional.get();
        }else {
            throw new NotFoundObjectException("planet does not exist!");
        }
        return planet;
    }

    @Override
    public void deletePlanet(int id) throws Exception {
        Optional<Planet> optional = planetRepository.findById(id);
        if (optional.isPresent()){
            planetRepository.deleteById(id);
        }else {
            throw new NotFoundObjectException("planet does not exist!");
        }
    }

    @Override
    public void savePlanet(Planet planet) {
        planetRepository.save(planet);
    }

    @Override
    public Planet entrustManagement(int id, Prince prince) throws Exception {
        Optional<Planet> optional = planetRepository.findById(id);
        Planet planet = null;

        check.checkingForExistenceOfPrince(prince);

        if (optional.isPresent()){
            planet = optional.get();
            planet.setPrince(prince);
            return planet;
        }else {
            throw new NotFoundObjectException("planet does not exist!");
        }
    }
}
