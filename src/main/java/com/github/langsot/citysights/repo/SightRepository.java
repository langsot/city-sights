package com.github.langsot.citysights.repo;

import com.github.langsot.citysights.entity.Sight;
import com.github.langsot.citysights.entity.SightType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SightRepository extends JpaRepository<Sight, Integer> {

    @Query("select s from Sight s where s.city_id = ?1")
    List<Sight> findAllByCity_id(Integer id);

    @Query("select s from Sight s where s.sight_type = ?1 order by s.name asc")
    List<Sight> findAllBySight_typeOrderByName(SightType filter);

    @Query("select s from Sight s where s.sight_type = ?1 order by s.name desc")
    List<Sight> findAllBySight_typeOrderByNameDesc(SightType filter);

    @Query("select s from Sight s where s.sight_type = ?1")
    List<Sight> findBySight_type(SightType filter);

    Optional<Sight> findById(Integer id);
}