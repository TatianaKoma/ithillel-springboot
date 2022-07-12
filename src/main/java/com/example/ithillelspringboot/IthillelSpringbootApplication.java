package com.example.ithillelspringboot;

import com.example.ithillelspringboot.repository.PersoneRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class IthillelSpringbootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(IthillelSpringbootApplication.class, args);
        PersoneRepository personeRepository = configurableApplicationContext.getBean(PersoneRepository.class);
    }
}
