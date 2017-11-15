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
        Person person = new Person();
        person.setName("test");
        person.setAge(10);
        personRepository.save(person);
    }

    @Test
    public void shouldFindPerson() {
        Person selectedPerson = personRepository.findByName("test");
        System.out.println(selectedPerson.toString());
    }
}
