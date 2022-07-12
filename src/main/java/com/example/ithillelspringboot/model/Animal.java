package com.example.ithillelspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id", updatable = false, nullable = false)
    private Integer animal_id;
    private String name;
    private String type;
    private String color;

    @ManyToOne
    @JoinColumn(name = "persone_id")
    @JsonIgnoreProperties("animals")
    private Persone persone;
}
