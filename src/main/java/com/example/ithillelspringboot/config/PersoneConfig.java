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
            Persone mark = new Persone("Mark", "Grant", 25);
            Persone maria = new Persone("Maria", "Peterson", 24);

            Animal tuzik = new Animal("Tuzik", "dog", "white");
            Animal barsik = new Animal("Barsik", "cat", "black");
            List<Animal> animals = Arrays.asList(tuzik, barsik);
            mark.setAnimals(animals);
            repository.saveAll(List.of(mark, maria));
        };
    }
}
