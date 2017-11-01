package org.ncmao;

import net.logstash.logback.marker.LogstashMarker;
import org.junit.Test;
import org.ncmao.domain.Singleton;
import org.ncmao.domain.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

import static net.logstash.logback.marker.Markers.appendFields;

public class SingletonTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SingletonTest.class);
    @Test
    public void canOnlyGetOneInstance(){
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton);
    }


    @Test
    public void shouldTest1() throws IllegalAccessException {
        Student student = new Student();
        student.setName("test");
        student.setAge(11);
        mapAll(student);
    }



    private void mapAll(Student student) throws IllegalAccessException {
        Class studentClass = student.getClass();
        Field[] declaredFields = studentClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
            declaredField.setAccessible(true);
            System.out.println(declaredField.get(student));
        }
        LogstashMarker logstashMarker = appendFields(student);
        LOGGER.info(logstashMarker, "test");


    }


}
