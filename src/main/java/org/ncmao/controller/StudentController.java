package org.ncmao.controller;


import org.ncmao.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(value = "/students")
public class StudentController {


    @RequestMapping(method = GET, value = "{id}")
    public @ResponseBody
    Student getStudent(@PathVariable int id, HttpSession httpSession) {
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
