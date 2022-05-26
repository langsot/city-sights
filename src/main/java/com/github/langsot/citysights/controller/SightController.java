package com.github.langsot.citysights.controller;

import com.github.langsot.citysights.entity.Sight;
import com.github.langsot.citysights.service.SightService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/sight")
@AllArgsConstructor
public class SightController {

    private SightService service;

    @GetMapping()
    public List<Sight> getAllSight() {
        return service.getAll();
    }

}
