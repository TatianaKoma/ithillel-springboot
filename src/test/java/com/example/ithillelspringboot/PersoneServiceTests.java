package com.example.ithillelspringboot;

import com.example.ithillelspringboot.service.PersoneService;
import com.example.ithillelspringboot.model.Persone;
import com.example.ithillelspringboot.repository.PersoneRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PersoneServiceTests {

    @InjectMocks
    private PersoneService personeService;

    @Mock
    private PersoneRepository personeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addNewPersoneTest() {
        Persone persone = new Persone();
        persone.setId(1);
        persone.setName("Alice");
        persone.setSurname("Smith");
        persone.setAge(27);

        Mockito.when(personeRepository.save(persone)).thenReturn(persone);
        assertThat(personeService.addNewPersone(persone)).isEqualTo(persone);
    }

    @Test
    public void getPersoneTest() {
        Persone persone = new Persone();
        persone.setId(1);
        persone.setName("Alice");
        persone.setSurname("Smith");
        persone.setAge(27);

        Mockito.when(personeRepository.findById(1)).thenReturn(Optional.of(persone));
        assertThat(personeService.getPersone(1)).isEqualTo(Optional.of(persone));

    }

    @Test
    public void getPersonesTest() {
        Persone persone1 = new Persone();
        persone1.setName("Alice");
        persone1.setSurname("Smith");
        persone1.setAge(27);

        Persone persone2 = new Persone();
        persone2.setName("Alex");
        persone2.setSurname("Smith");
        persone2.setAge(30);

        List<Persone> personeList = new ArrayList<>();
        personeList.add(persone1);
        personeList.add(persone2);
        Mockito.when(personeRepository.findAll()).thenReturn(personeList);
        assertThat(personeService.getPersones()).isEqualTo(personeList);
    }

    @Test
    public void deletePersoneTest() {
        Persone persone = new Persone();
        persone.setId(1);
        persone.setName("Alice");
        persone.setSurname("Smith");
        persone.setAge(27);

        Mockito.when(personeRepository.findById(1)).thenReturn(Optional.of(persone));
        Mockito.when(personeRepository.existsById(persone.getId())).thenReturn(false);
        assertFalse(personeRepository.existsById(persone.getId()));
    }

    @Test
    public void updatePersoneTest() {
        Persone persone = new Persone();
        persone.setId(1);
        persone.setName("Alice");
        persone.setSurname("Smith");
        persone.setAge(27);
        Mockito.when(personeRepository.findById(1)).thenReturn(Optional.of(persone));
        persone.setName("Mark");
        Mockito.when(personeRepository.save(persone)).thenReturn(persone);
    }
}
