package com.github.langsot.citysights.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer population;

    private Boolean metro;

    private String country;

    @OneToMany(mappedBy = "city_id")
    @JsonIgnore
    private List<Sight> sights;
}
