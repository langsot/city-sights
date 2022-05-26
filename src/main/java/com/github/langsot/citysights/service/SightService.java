package com.github.langsot.citysights.service;

import com.github.langsot.citysights.entity.City;
import com.github.langsot.citysights.entity.Sight;
import com.github.langsot.citysights.repo.SightRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SightService {

    private SightRepository repository;

    public List<Sight> getAll() {
        return repository.findAll();
    }

    public void save(Sight sight) {
        repository.save(sight);
    }
}
