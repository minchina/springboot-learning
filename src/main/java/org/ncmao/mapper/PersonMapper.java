package org.ncmao.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.ncmao.domain.Person;

@Mapper
public interface PersonMapper {


    void save(Person person);


    Person selectById(@Param("id") Long id);

    void deleteAll();


}
