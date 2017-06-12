package org.ncmao.service;


import org.ncmao.domain.Person;
import org.ncmao.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonMapper personMapper;

    public void save(Person person) {
        personMapper.save(person);
    }

    public Person findById(Long id) {
        return personMapper.selectById(id);
    }

    public void deleteAll() {
        personMapper.deleteAll();
    }
}
