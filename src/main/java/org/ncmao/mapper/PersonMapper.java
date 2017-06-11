package org.ncmao.mapper;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.ncmao.domain.Person;

@Mapper
public interface PersonMapper {


//    @Insert("insert into person(name, age) values (#{name}, #{age})")
//    @Options(useGeneratedKeys = true, keyColumn = "id")
    void save(Person person);


    @Select("select id, name ,age from person where id=#{id}")
    Person selectById(@Param("id") Long id);

    @Delete("delete from person")
    void deleteAll();


}
