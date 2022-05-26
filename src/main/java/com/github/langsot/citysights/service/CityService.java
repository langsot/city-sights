package com.github.langsot.citysights.service;

import com.github.langsot.citysights.entity.City;
import com.github.langsot.citysights.repo.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityService {

    private CityRepository repository;


    public void add(City city) {
        repository.save(city);
    }

    public List<City> getAll() {
        return repository.findAll();
    }

}
