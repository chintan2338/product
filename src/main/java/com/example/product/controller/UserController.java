package com.example.product.controller;

import com.example.product.entity.Course;
import com.example.product.entity.Employee;
import com.example.product.entity.Student;
import com.example.product.entity.User;
import com.example.product.repository.CourseRepository;
import com.example.product.repository.StudentRepository;
import com.example.product.service.EmployeeService;
import com.example.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/oneToMany")
    public List<User> getAllUsers() {
        return userService.getAllUsersWithAddresses();
    }

    @GetMapping("/oneToOne")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> list = employeeService.getAllEmployees();
        return ResponseEntity.ok(list);
    }

    @GetMapping("ManyToMany")
    public List<Course> getAllStudents() {
        return courseRepository.findAll();
    }

    @GetMapping("api")
    public List<Course> getAlslStudents() {
//        API Call karis ManyToMany vadi
//        API ma thi response body lai ne return karais.
        return null;
//        return courseRepository.findAll();
    }

}
