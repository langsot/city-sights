package com.github.langsot.citysights.repo;

import com.github.langsot.citysights.entity.Sight;
import com.github.langsot.citysights.entity.SightType;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SightRepository extends JpaRepository<Sight, Integer> {

    @Query("select s from Sight s where s.city_id = ?1")
    List<Sight> findAllByCity_id(Integer id);

    @Query("select s from Sight s where s.sight_type = ?1")
    List<Sight> findAllBySight_type(SightType filter, Sort name);

    Optional<Sight> findById(Integer id);
}