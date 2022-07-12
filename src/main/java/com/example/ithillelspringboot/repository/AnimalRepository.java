package com.example.ithillelspringboot.repository;

import com.example.ithillelspringboot.model.Animal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Integer> {
}
