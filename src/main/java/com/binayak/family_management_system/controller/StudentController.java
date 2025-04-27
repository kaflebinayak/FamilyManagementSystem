package com.binayak.family_management_system.controller;

import com.binayak.family_management_system.entity.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class StudentController {

    private List<Student> students =new ArrayList<>(List.of(
            new Student (1,"Binayak",90),
            new Student (2,"Suman",85),
            new Student(3,"Pemba",65)

    ));

    @CrossOrigin(origins = "*")
    @GetMapping("/students")
    public List<Student> getStudents(){
    return  students;
    }

    @CrossOrigin(origins = "*")
//    csrf Token
    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){

        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }
}
