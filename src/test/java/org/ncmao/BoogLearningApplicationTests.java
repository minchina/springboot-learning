package org.ncmao;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ncmao.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

		Person foundPerson = personService.findById(person.getId());
		assertThat(foundPerson.getName(), is("test111"));
	}

	@After
	public void destory(){
		personService.deleteAll();
	}

}
