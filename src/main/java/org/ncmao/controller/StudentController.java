package org.ncmao.controller;


import org.ncmao.domain.Student;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/students")
public class StudentController {


    private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @RequestMapping(method = GET,value = "{id}", produces = APPLICATION_XML_VALUE )
    public Student getStudent(@PathVariable int id, HttpSession httpSession) {
        LOGGER.info("print xml");
        UUID uid = (UUID) httpSession.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
            httpSession.setAttribute("uid" + id, uid);
        }
        Student student = new Student();
        student.setAge(10);
        student.setName("ningchuan");
        return student;
    }
}
