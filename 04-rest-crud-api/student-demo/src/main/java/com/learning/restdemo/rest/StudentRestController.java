package com.learning.restdemo.rest;

import com.learning.restdemo.entity.Student;
import com.learning.restdemo.errors.StudentErrorResponse;
import com.learning.restdemo.errors.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents = new ArrayList<>();

    @PostConstruct
    public void loadData() {
        theStudents.add(new Student("Shooter", "Dival"));
        theStudents.add(new Student("Mario", "Casas"));
        theStudents.add(new Student("Casandra", "Diegos"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        if(studentId >= theStudents.size() || studentId < 0)
            throw new StudentNotFoundException("Student id not found: " + studentId);

        return theStudents.get(studentId);
    }
}
