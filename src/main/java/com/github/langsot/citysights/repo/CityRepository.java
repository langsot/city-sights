package com.github.langsot.citysights.repo;

import com.github.langsot.citysights.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
