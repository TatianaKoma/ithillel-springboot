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

    public void updateAnimal(Animal newAnimal) {
        Animal animal = animalRepository.findById(newAnimal.getId())
                .orElseThrow(() -> new IllegalStateException("animal with id " + newAnimal.getId() +
                        " doesn't exists"));
        if (newAnimal.getName() != null &&
                newAnimal.getName().length() > 0 &&
                !Objects.equals(animal.getName(), newAnimal.getName())) {
            animal.setName(newAnimal.getName());
        }
        if (newAnimal.getType() != null &&
                newAnimal.getType().length() > 0 &&
                !Objects.equals(animal.getType(), newAnimal.getType())) {
            animal.setType(newAnimal.getType());
        }
        if (newAnimal.getColor() != null &&
                newAnimal.getColor().length() > 0 &&
                !Objects.equals(animal.getColor(), newAnimal.getColor())) {
            animal.setColor(newAnimal.getColor());
        }
    }

    public Optional<Animal> getAnimal(Integer animalId) {
        return animalRepository.findById(animalId);
    }
}
