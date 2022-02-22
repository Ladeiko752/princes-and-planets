package com.web.princes_and_planets.dao;

import com.web.princes_and_planets.entity.Prince;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrinceRepository extends JpaRepository<Prince, Integer> {
    /*
    * MySQL Query
    * SELECT * FROM space.prince ORDER BY age LIMIT 0, 10
    * */
    List<Prince> findTop10ByOrderByAge();
}
