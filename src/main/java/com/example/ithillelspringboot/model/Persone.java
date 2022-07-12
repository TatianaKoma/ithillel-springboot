package com.example.ithillelspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "persone_id", updatable = false, nullable = false)
    private Integer personeId;
    private String name;
    private String surname;
    private Integer age;

    @OneToMany(mappedBy = "persone", targetEntity = Animal.class,
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("persone")
    private List<Animal> animals = new ArrayList<>();
}
