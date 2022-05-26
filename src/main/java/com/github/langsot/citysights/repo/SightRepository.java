package com.github.langsot.citysights.repo;

import com.github.langsot.citysights.entity.Sight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SightRepository extends JpaRepository<Sight, Long> {
}