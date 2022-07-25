package com.eagle.Event.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Data
public class EventDto {
    private Long id;
    private String name;
    private String description;
    private boolean child = false;
    private int places;
    private Double prix;
    private String address;
    private LocalDate date = LocalDate.of(2022, 05, 13);
    private LocalTime heureDebut;
    private LocalTime heureFin;
}
