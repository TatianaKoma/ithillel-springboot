package com.example.ithillelspringboot.service;

import com.example.ithillelspringboot.model.Animal;
import com.example.ithillelspringboot.model.Persone;
import com.example.ithillelspringboot.repository.AnimalRepository;
import com.example.ithillelspringboot.repository.PersoneRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
    private final PersoneRepository personeRepository;
    private final SessionFactory sessionFactory;

    @Autowired
    public AnimalService(AnimalRepository animalRepository,
                         PersoneRepository personeRepository, SessionFactory sessionFactory) {
        this.animalRepository = animalRepository;
        this.personeRepository = personeRepository;
        this.sessionFactory = sessionFactory;
    }

    public List<Animal> getAnimals() {
        return (List<Animal>) animalRepository.findAll();
    }

    public Animal addNewAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public void deleteAnimal(Integer animalId) {
        boolean exists = animalRepository.existsById(animalId);
        if (!exists) {
            throw new IllegalStateException(
                    "animal with id " + animalId + " doesn't exists");
        }
        animalRepository.deleteById(animalId);
    }

    public void deleteAnimalWithPersone(Integer animalId) {
        Integer personeId = animalRepository.findById(animalId).get().getPersone().getPersoneId();
        animalRepository.deleteById(animalId);
        personeRepository.deleteById(personeId);
    }

    public Persone getPersoneByAnimalId(Integer animalId) {
        Session currentSession = this.sessionFactory.openSession();
        Animal animal = currentSession.find(Animal.class, animalId);
        return animal.getPersone();
    }

    public Animal updateAnimal(Animal newAnimal) {
        Animal animal = animalRepository.findById(newAnimal.getAnimal_id())
                .orElseThrow(() -> new IllegalStateException("animal with id " + newAnimal.getAnimal_id() +
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
        return animalRepository.save(animal);
    }

    public Optional<Animal> getAnimal(Integer animalId) {
        return animalRepository.findById(animalId);
    }
}
