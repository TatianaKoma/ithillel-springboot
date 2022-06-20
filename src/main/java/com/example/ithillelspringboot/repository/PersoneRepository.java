package com.example.ithillelspringboot.repository;

import com.example.ithillelspringboot.model.Persone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersoneRepository extends JpaRepository<Persone, Integer> {
}
