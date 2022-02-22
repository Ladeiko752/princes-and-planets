package com.web.princes_and_planets.controller;

import com.web.princes_and_planets.entity.Prince;
import com.web.princes_and_planets.service.implementation.PrinceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class PrinceController {
    private final PrinceServiceImpl princeService;

    @Autowired
    public PrinceController(PrinceServiceImpl princeService) {
        this.princeService = princeService;
    }

    @GetMapping("/princes")
    public List<Prince> getListOfPrinces(){
        return princeService.getAll();
    }

    @PostMapping("/princes")
    public Prince addPrince(@RequestBody Prince prince){
        princeService.savePrince(prince);
        return prince;
    }

    @GetMapping("/princes/{id}")
    public Prince getPrinceOnId(@PathVariable int id) throws Exception {
        return princeService.getPrinceOnId(id);
    }

    @GetMapping("/princes/slackers")
    public List<Prince> getListOfSlackers(){
        return princeService.getSlacker();
    }

    @GetMapping("/princes/top_young")
    public List<Prince> getSortedListOfPrinces(){
        return princeService.getTopTenYoungPrinces();
    }
}
