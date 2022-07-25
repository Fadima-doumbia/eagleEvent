package com.eagle.Event.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
@Table(	name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
