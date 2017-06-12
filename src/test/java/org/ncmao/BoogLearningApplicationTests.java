package org.ncmao;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ncmao.domain.Person;
import org.ncmao.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BoogLearningApplicationTests {

	@Autowired
	private PersonService personService;


	@Test
	public void contextLoads() {
	}

	@Test
	public void shouldSavePersonSuccess(){
		Person person = new Person();
		person.setName("test");
		person.setAge(11);
		personService.save(person);
	}

	@Test
	public void shouldfindById(){
		Person person = new Person();
		person.setName("test111");
		person.setAge(11);
		personService.save(person);

		Person foundPerson = personService.findById(person.getId());
		assertThat(foundPerson.getName(), is("test111"));

		Person foundPersonAgain = personService.findById(person.getId());
		assertThat(foundPersonAgain.getName(), is("test111"));
	}

	@Test
	public void shouldFoundMultiPerson() {
		Person person = new Person();
		person.setName("test1");
		person.setAge(20);
		personService.save(person);

		Person person1 = new Person();
		person1.setName("test1");
		person1.setAge(20);
		personService.save(person1);

		List<Person> persons = personService.findByAge(20);
		assertThat(persons.size(), is(2));

	}

	@After
	public void destory(){
		personService.deleteAll();
	}

}
