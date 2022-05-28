package com.github.langsot.citysights.repo;

import com.github.langsot.citysights.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Integer> {

    Optional<City> findById(Integer id);
}
