package com.example.ithillelspringboot.controller;

import com.example.ithillelspringboot.model.Animal;
import com.example.ithillelspringboot.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/animal")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public List<Animal> getAnimals() {
        return animalService.getAnimals();
    }

    @GetMapping(value = "/{animalId}")
    public Optional<Animal> getAnimal(@PathVariable("animalId") Integer animalId) {
        return animalService.getAnimal(animalId);
    }

    @PostMapping
    public void registerNewAnimal(@RequestBody Animal animal) {
        System.out.println(animal);
        animalService.addNewAnimal(animal);
    }

    @PutMapping
    public void updateAnimal(@RequestBody Animal animal) {
        System.out.println(animal);
        animalService.updateAnimal(animal);
    }

    @DeleteMapping(path = "/{animalId}")
    public void deleteAnimal(@PathVariable("animalId") Integer animalId) {
        animalService.deleteAnimal(animalId);
    }
}
