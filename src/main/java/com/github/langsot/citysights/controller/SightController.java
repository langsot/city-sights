package com.github.langsot.citysights.controller;

import com.github.langsot.citysights.entity.Sight;
import com.github.langsot.citysights.entity.SightType;
import com.github.langsot.citysights.exception.SightNotFoundException;
import com.github.langsot.citysights.repo.CityRepository;
import com.github.langsot.citysights.repo.SightRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/sight")
@AllArgsConstructor
public class SightController {

    private SightRepository repository;
    private CityRepository repository1;

    /**
     * Получение списка достопримечательносей
     * @param sort : Параметр сортровки по имени 'a' - по возрастанию, 'z' - по убыванию
     * @param filter : Параметр фильтрации по типу достопримечательности
     * @return Результирующий список. Если параметры пустые - выводит всё
     */
    @Operation(summary = "Получение всех Sights, либо с учетом параметров. sort принимает два параметра 'a' and 'z'")
    @GetMapping()
    public ResponseEntity<List<Sight>> getAllSight(@RequestParam(required = false) Character sort,
                                   @RequestParam(required = false) SightType filter) {
        log.info("Получаем какой то список достопримечательностей");

        if (sort != null && sort.equals('a')) {
            return new ResponseEntity<>(filter == null
                    ? repository.findAll(Sort.by("name"))
                    : repository.findAllBySight_typeOrderByName(filter),HttpStatus.OK);
        }
        if (sort != null && sort.equals('z')) {
            return new ResponseEntity<>(filter == null
                    ? repository.findAll(Sort.by(Sort.Direction.DESC, "name"))
                    : repository.findAllBySight_typeOrderByNameDesc(filter), HttpStatus.OK);
        }
        if (filter != null && sort == null) {
            return new ResponseEntity<>(repository.findBySight_type(filter), HttpStatus.OK);
        }

        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    /**
     * Метод для полученя достопримечательностей отдельного города
     * @param id Уникальный идентификатор города
     * @return Получение всех досопримечательностей города
     */
    @Operation(summary = "Получение всех достопримечательностей города по, соответсвенно, его id")
    @GetMapping("{id}")
    public ResponseEntity<List<Sight>> getAllSightsInCity(@PathVariable("id") Integer id) {
        List<Sight> sights = new ArrayList<>(repository1.getAllSights(id));
        return new ResponseEntity<>(sights, HttpStatus.OK);
    }

    /**
     * Обновление информации о Достопримечательности
     * @param id Уникальный идентификатор Sight
     * @param newSight Сущность, параметры которой(description) будут скопированны в существующую запись
     * @return Статус и обновленная сущность
     */
    @Operation(summary = "Обновление описания. Only description")
    @PutMapping("/update/{id}")
    public ResponseEntity<Sight> updateCity(@PathVariable("id") Integer id,
                                            @RequestBody Sight newSight) {
        log.info("Обновление параметра Достопримечательности");
        Sight sight = repository.findById(id)
                .orElseThrow(() -> new SightNotFoundException("Не найден Sight с id = " + id));
        if (newSight.getDescription() != null) {
            log.info("Обновление description");
            sight.setDescription(newSight.getDescription());
        }
        log.info("Сохранение Sight {}", sight);
        repository.save(sight);
        return new ResponseEntity<>(sight, HttpStatus.ACCEPTED);
    }


    /**
     * Добавление новой достопримечательности
     * @param sight Создаваемый объект класса Sight
     * @return результат работы метода save в теле ResponseEntity
     */
    @Operation(summary = "Добавление новой достопримечательности. В city_id указать только id")
    @PostMapping
    public ResponseEntity<Sight> addSight(@RequestBody Sight sight) {
        log.info("Добавление достопримечательности {}", sight);

        sight.setId(null);
        ResponseEntity<Sight> responseEntity = new ResponseEntity<>(repository.save(sight), HttpStatus.CREATED);

        log.info("Достопримечательность добавлена DONE");
        return responseEntity;
    }

    /**
     * Метод удаления достопримечательности
     * @param id : Уникальный идентификатор достопримечательности
     * @return Статус запроса
     */
    @Operation(summary = "Удаление достопримечательности по её id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Sight> deleteSight(@PathVariable("id") Integer id) {
        log.info("Запрос на удаление достопримечательности");

        if (!repository.existsById(id)) {
            log.info("Достопримечательность с id: {} не найдена", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repository.deleteById(id);
        log.info("Достопримечательность с id: {} успешно удалена", id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
