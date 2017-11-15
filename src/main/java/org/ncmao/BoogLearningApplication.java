package org.ncmao;

import org.ncmao.domain.Person;
import org.ncmao.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ncmao
 */
@SpringBootApplication
public class BoogLearningApplication  {

	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(BoogLearningApplication.class, args);
	}

}
