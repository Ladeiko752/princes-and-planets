package com.web.princes_and_planets.exam;

import com.web.princes_and_planets.entity.Prince;
import com.web.princes_and_planets.exception.NotFoundObjectException;
import com.web.princes_and_planets.service.implementation.PrinceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Check {
    private final PrinceServiceImpl princeService;

    @Autowired
    public Check(PrinceServiceImpl princeService) {
        this.princeService = princeService;
    }

    public boolean checkingForExistenceOfPrince(Prince prince) throws NotFoundObjectException {
        List<Prince> princes = princeService.getAll();

        for (int i = 0; i < princes.size(); i++){
            if (prince.equals(princes.get(i))){
                return true;
            }
        }
        throw new NotFoundObjectException("prince does not exist!");
    }
}
