package org.ncmao.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.ncmao.domain.Person;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PersonMapper {


    void save(Person person);


    Person selectById(@Param("id") Long id);

    void deleteAll();

    List<Person> selectByAge(@Param("age") int age);

}
