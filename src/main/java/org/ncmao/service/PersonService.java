package org.ncmao.service;


import org.ncmao.domain.Person;
import org.ncmao.mapper.PersonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    public void save(Person person) {
        personMapper.save(person);
    }

    public Person findById(Long id) {
        String key = "person_" + id;
        ValueOperations<String, Person> valueOperations = redisTemplate.opsForValue();

        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            Person person = valueOperations.get(key);
            LOGGER.info("PersonService.findById() : 从缓存中获取了 >> " + person.toString());
            return person;
        }
        Person personFromDB = personMapper.selectById(id);
        valueOperations.set(key, personFromDB);
        LOGGER.info("PersonService.findById() : Person插入缓存 >> " + personFromDB.toString());

        return personFromDB;
    }

    public void deleteAll() {
        personMapper.deleteAll();
    }

    public List<Person> findByAge(int age) {
        return personMapper.selectByAge(age);
    }
}
