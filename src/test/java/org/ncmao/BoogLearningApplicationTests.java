package org.ncmao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ncmao.domain.Person;
import org.ncmao.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BoogLearningApplicationTests {

    @Autowired
    private PersonRepository personRepository;


    @Test
    public void contextLoads() {

    }

    @Test
    public void shouldSavePerson() {
        personRepository.deleteAll();
    }

    @Test
    public void shouldFindPerson() {

        personRepository.findByName("test2");
        personRepository.findByName("test2");
        personRepository.findByName("test2");
    }
}
