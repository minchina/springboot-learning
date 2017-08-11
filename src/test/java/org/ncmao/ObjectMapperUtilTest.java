package org.ncmao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.ncmao.domain.Person;
import org.ncmao.util.ObjectMapperUtil;

public class ObjectMapperUtilTest {



    @Test
    public void shouldConvertObjectToJsonString() throws JsonProcessingException {
        Person person = new Person();
        person.setAge(11);
        person.setName("test");
        ObjectMapper objectMapper = ObjectMapperUtil.getInstance();
        String jsonedPerson = objectMapper.writeValueAsString(person);
        System.out.println(jsonedPerson);

    }
}
