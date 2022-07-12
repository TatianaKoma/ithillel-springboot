package com.example.ithillelspringboot.config;

import com.example.ithillelspringboot.model.Animal;
import com.example.ithillelspringboot.model.Persone;
import com.example.ithillelspringboot.repository.PersoneRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class PersoneConfig {
    @Bean
    CommandLineRunner commandLineRunner(PersoneRepository repository) {
        return args -> {
            Persone mark = new Persone();
            mark.setName("Mark");
            mark.setSurname("Smith");
            mark.setAge(27);
            Persone maria = new Persone();
            maria.setName("Maria");
            maria.setSurname("Grant");
            maria.setAge(25);

            Animal tuzik = new Animal();
            tuzik.setName("Tuzik");
            tuzik.setType("dog");
            tuzik.setColor("white");
            tuzik.setPersone(mark);
            Animal barsik = new Animal();
            barsik.setName("Barsik");
            barsik.setType("cat");
            barsik.setColor("grey");
            barsik.setPersone(mark);
            List<Animal> animals = Arrays.asList(tuzik, barsik);
            mark.setAnimals(animals);
            repository.saveAll(List.of(mark, maria));
        };
    }
}
