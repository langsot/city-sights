package com.github.langsot.citysights.controller;

import com.github.langsot.citysights.entity.City;
import com.github.langsot.citysights.exception.CityNotFoundException;
import com.github.langsot.citysights.repo.CityRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/city")
@AllArgsConstructor
public class CityController {

    private CityRepository repository;


    @GetMapping()
    public List<City> getAllCity() {
        return repository.findAll();
    }


    /**
     * Обноление информации о городе
     * @param id : уникальный идентификатор города
     * @param newCity : Сущность, параметры которой(population, metro)
     *               будут скопированны в существующую запись
     * @return Обновленная сущность
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<City> updateCity(@PathVariable("id") Integer id,
                           @RequestBody City newCity) {
        log.info("Обновление параметров Города");
        City city = repository.findById(id)
                .orElseThrow(() -> new CityNotFoundException("Не найден Город с id = " + id));
        if (newCity.getPopulation() != null) {
            log.info("Обновление числа горожан");
            city.setPopulation(newCity.getPopulation());
        }
        if (newCity.getMetro() != null) {
            log.info("Обновление статуса метро");
            city.setMetro(newCity.getMetro());
        }
        log.info("Сохранение города {}", city);
        repository.save(city);
        return new ResponseEntity<>(city, HttpStatus.ACCEPTED);
    }

    /**
     * Добавление нового города
     * @param city Создаваемый объект класса City
     * @return результат работы метода save в теле ResponseEntity
     */
    @PostMapping
    public ResponseEntity<City> addCity(@RequestBody City city) {
        log.info("Добавление города {}", city);

        city.setId(null);
        ResponseEntity<City> responseEntity = new ResponseEntity<>(repository.save(city), HttpStatus.CREATED);

        log.info("Город добавлен DONE");
        return responseEntity;
    }


}
