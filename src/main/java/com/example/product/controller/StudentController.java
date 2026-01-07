package com.example.product.controller;

import com.example.product.entity.Student;
import com.example.product.service.StudentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent() {
        Student savedStudent = studentService.saveStudentWithCourses();
        return ResponseEntity.ok(savedStudent);
    }
}
