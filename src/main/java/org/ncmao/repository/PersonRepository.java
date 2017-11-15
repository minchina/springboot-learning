package org.ncmao.repository;


import com.sun.istack.internal.Nullable;
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


    @Nullable
    @Cacheable(key = "#p0")
    Person findByName(@Nullable String name);


    @CachePut(key = "#p0.name")
    @Override
    Person save(Person person);
}
