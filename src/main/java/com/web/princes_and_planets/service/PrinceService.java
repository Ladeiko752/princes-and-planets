package com.web.princes_and_planets.service;

import com.web.princes_and_planets.entity.Prince;

import java.util.List;

public interface PrinceService {
    public List<Prince> getAll();
    public Prince getPrinceOnId(int id) throws Exception;
    public void savePrince(Prince prince);
    public void deletePrince(int id) throws Exception;
    public List<Prince> getSlacker();
    public List<Prince> getTopTenYoungPrinces();
}
