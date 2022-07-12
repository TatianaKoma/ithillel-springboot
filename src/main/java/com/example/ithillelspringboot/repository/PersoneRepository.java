package com.example.ithillelspringboot.repository;

import com.example.ithillelspringboot.model.Persone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersoneRepository extends CrudRepository<Persone, Integer> {
}
