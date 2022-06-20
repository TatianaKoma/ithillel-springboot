package com.example.ithillelspringboot.service;

import com.example.ithillelspringboot.model.Persone;
import com.example.ithillelspringboot.repository.PersoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class PersoneService {
    private final PersoneRepository personeRepository;

    @Autowired
    public PersoneService(PersoneRepository personeRepository) {
        this.personeRepository = personeRepository;
    }

    public List<Persone> getPersones() {
        return personeRepository.findAll();
    }

    public void addNewPersone(Persone persone) {
        personeRepository.save(persone);
    }

    public void deletePersone(Integer personeId) {
        boolean exists = personeRepository.existsById(personeId);
        if (!exists) {
            throw new IllegalStateException(
                    "persone with id " + personeId + " doesn't exists");
        }
        personeRepository.deleteById(personeId);
    }


    public void updatePersone(
            Integer personeId, String name, String surname, Integer age) {
        Persone persone = personeRepository.findById(personeId)
                .orElseThrow(() -> new IllegalStateException("persone with id " + personeId +
                        " doesn't exists"));
        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(persone.getName(), name)) {
            persone.setName(name);
        }
        if (surname != null &&
                surname.length() > 0 &&
                !Objects.equals(persone.getSurname(), surname)) {
            persone.setSurname(surname);
        }
        if (age != null &&
                age > 0 &&
                !Objects.equals(persone.getAge(), age)) {
            persone.setAge(age);
        }
    }

    public Optional<Persone> getPersone(Integer personeId) {
        return personeRepository.findById(personeId);
    }
}

