package com.github.langsot.citysights.controller;

import com.github.langsot.citysights.entity.City;
import com.github.langsot.citysights.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/city")
@AllArgsConstructor
public class CityController {

    private CityService cityService;


    @GetMapping()
    public List<City> getAllCity() {
        return cityService.getAll();
    }

    @GetMapping("/city/{sowrt}/")
    public List<City> getAllSortedCity(@PathVariable("sort") Long sort) {
        return Collections.EMPTY_LIST;
    }
}
