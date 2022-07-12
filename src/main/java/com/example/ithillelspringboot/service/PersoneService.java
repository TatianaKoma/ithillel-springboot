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
        return (List<Persone>) personeRepository.findAll();
    }

    public Persone addNewPersone(Persone persone) {
        return personeRepository.save(persone);
    }

    public void deletePersone(Integer personeId) {
        boolean exists = personeRepository.existsById(personeId);
        if (!exists) {
            throw new IllegalStateException(
                    "persone with id " + personeId + " doesn't exists");
        }
        personeRepository.deleteById(personeId);
    }

    public Persone updatePersone(Persone newPersone) {
        Persone persone = personeRepository.findById(newPersone.getPersoneId())
                .orElseThrow(() -> new IllegalStateException("persone with id " + newPersone.getPersoneId() +
                        " doesn't exists"));
        if (newPersone.getName() != null &&
                newPersone.getName().length() > 0 &&
                !Objects.equals(persone.getName(), newPersone.getName())) {
            persone.setName(newPersone.getName());
        }
        if (newPersone.getSurname() != null &&
                newPersone.getSurname().length() > 0 &&
                !Objects.equals(persone.getSurname(), newPersone.getSurname())) {
            persone.setSurname(newPersone.getSurname());
        }
        if (newPersone.getAge() != null &&
                newPersone.getAge() > 0 &&
                !Objects.equals(persone.getAge(), newPersone.getAge())) {
            persone.setAge(newPersone.getAge());
        }
        return personeRepository.save(persone);
    }

    public Optional<Persone> getPersone(Integer personeId) {
        return personeRepository.findById(personeId);
    }
}
