package com.example.ithillelspringboot.service;

import com.example.ithillelspringboot.model.Animal;
import com.example.ithillelspringboot.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class AnimalService {
    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAnimals() {
        return animalRepository.findAll();
    }

    public void addNewAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    public void deleteAnimal(Integer animalId) {
        boolean exists = animalRepository.existsById(animalId);
        if (!exists) {
            throw new IllegalStateException(
                    "animal with id " + animalId + " doesn't exists");
        }
        animalRepository.deleteById(animalId);
    }


    public void updateAnimal(
            Integer animalId, String name, String type, String color) {
        Animal animal = animalRepository.findById(animalId)
                .orElseThrow(() -> new IllegalStateException("animal with id " + animalId +
                        " doesn't exists"));
        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(animal.getName(), name)) {
            animal.setName(name);
        }
        if (type != null &&
                type.length() > 0 &&
                !Objects.equals(animal.getType(), type)) {
            animal.setType(type);
        }
        if (color != null &&
                color.length() > 0 &&
                !Objects.equals(animal.getColor(), color)) {
            animal.setColor(color);
        }
    }

    public Optional<Animal> getAnimal(Integer animalId) {
        return animalRepository.findById(animalId);
    }
}

