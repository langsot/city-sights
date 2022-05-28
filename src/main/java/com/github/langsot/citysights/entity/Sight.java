package com.github.langsot.citysights.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "sights")
public class Sight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private LocalDate date;

    private String description;

    @Enumerated(EnumType.STRING)
    private SightType sight_type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    @ToString.Exclude
    private City city_id;

    @JsonProperty("city_id")
    private void keks(Integer id) {
        this.city_id = new City();
        city_id.setId(id);
    }
}
