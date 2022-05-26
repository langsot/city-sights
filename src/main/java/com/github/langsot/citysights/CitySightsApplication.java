package com.github.langsot.citysights;

import com.github.langsot.citysights.entity.City;
import com.github.langsot.citysights.repo.CityRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CitySightsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CitySightsApplication.class, args);
    }

}