package com.example.ithillelspringboot.controller;

import com.example.ithillelspringboot.model.Persone;
import com.example.ithillelspringboot.service.PersoneService;
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
@RequestMapping(path = "api/v1/persone")
public class PersoneController {

    private final PersoneService personeService;

    @Autowired
    public PersoneController(PersoneService personeService) {
        this.personeService = personeService;
    }

    @GetMapping
    public List<Persone> getPersons() {
        return personeService.getPersones();
    }

    @GetMapping(value = "{personeId}")
    public Optional<Persone> getPersone(@PathVariable("personeId") Integer personeId) {
        System.out.println(personeId);
        return personeService.getPersone(personeId);
    }

    @PostMapping
    public void registerNewPersone(@RequestBody Persone persone) {
        System.out.println(persone);
        personeService.addNewPersone(persone);
    }


    @PutMapping
    public void updatePersone(@RequestBody Persone persone) {
        System.out.println(persone);
        personeService.updatePersone(persone.getId(), persone.getName(), persone.getSurname(), persone.getAge());
    }

    @DeleteMapping(path = "/{personeId}")
    public void deletePersone(@PathVariable("personeId") Integer personeId) {
        personeService.deletePersone(personeId);
    }
}
