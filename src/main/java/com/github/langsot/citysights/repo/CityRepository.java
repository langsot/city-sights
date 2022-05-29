package com.github.langsot.citysights.repo;

import com.github.langsot.citysights.entity.City;
import com.github.langsot.citysights.entity.Sight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Integer> {

    Optional<City> findById(Integer id);

    @Query("select u.sights from City u where u.id = ?1")
    List<Sight> getAllSights(Integer id);
}
