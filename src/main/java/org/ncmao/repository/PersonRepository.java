package org.ncmao.repository;


import org.ncmao.domain.Person;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ncmao
 */

@CacheConfig(cacheNames = "person")
public interface PersonRepository extends JpaRepository<Person, Long> {


    @Cacheable(key = "#p0")
    Person findByName(String name);


    @CachePut(key = "#p0.name")
    @Override
    Person save(Person person);
}
