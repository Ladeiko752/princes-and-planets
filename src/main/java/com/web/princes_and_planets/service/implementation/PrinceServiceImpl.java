package com.web.princes_and_planets.service.implementation;

import com.web.princes_and_planets.dao.PlanetRepository;
import com.web.princes_and_planets.dao.PrinceRepository;
import com.web.princes_and_planets.entity.Prince;
import com.web.princes_and_planets.exception.NotFoundObjectException;
import com.web.princes_and_planets.service.PrinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PrinceServiceImpl implements PrinceService {
    private final PrinceRepository princeRepository;

    @Autowired
    public PrinceServiceImpl(PrinceRepository princeRepository, PlanetRepository planetRepository) {
        this.princeRepository = princeRepository;
    }

    @Override
    public List<Prince> getAll() {
        return princeRepository.findAll();
    }

    @Override
    public Prince getPrinceOnId(int id) throws Exception {
        Prince prince = null;
        Optional<Prince> optional = princeRepository.findById(id);

        if (optional.isPresent()){
            prince = optional.get();
            return prince;
        } else {
            throw new NotFoundObjectException("prince does not exist!");
        }
    }

    @Override
    public void savePrince(Prince prince) {
        princeRepository.save(prince);
    }

    @Override
    public void deletePrince(int id) throws Exception {
        Optional<Prince> optional = princeRepository.findById(id);
        if (optional.isPresent()){
            princeRepository.deleteById(id);
        }else {
            throw new NotFoundObjectException("prince does not exist!");
        }
    }

    @Override
    public List<Prince> getSlacker(){
        List<Prince> princes = new ArrayList<>();
        for (Prince prince : getAll()){
            if (prince.getPlanets().isEmpty()){
                princes.add(prince);
            }
        }
        return princes;
    }

    @Override
    public List<Prince> getTopTenYoungPrinces(){
        return princeRepository.findTop10ByOrderByAge();
    }
}
