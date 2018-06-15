package org.ncmao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ncmao.domain.Clazz;
import org.ncmao.domain.Person;
import org.ncmao.repository.ClazzRepository;
import org.ncmao.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BoogLearningApplicationTests {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ClazzRepository clazzRepository;


    @Test
    public void contextLoads() {

    }

    @Test
    public void shouldSavePerson() {

        Clazz clazz = new Clazz();
        clazz.setName("class1");
        Clazz savedClazz = clazzRepository.save(clazz);

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            Person person = new Person();
            person.setName("test");
            person.setAge(10);
            person.setClazz(savedClazz);
            people.add(person);
        }

        personRepository.save(people);
    }

    @Test
    public void shouldFindPerson() {
        Clazz clazz = clazzRepository.findOne(1L);
        System.out.println(clazz.getName());
    }
}
