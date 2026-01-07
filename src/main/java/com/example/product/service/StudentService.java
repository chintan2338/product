package com.example.product.service;

import com.example.product.entity.Course;
import com.example.product.entity.Student;
import com.example.product.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudentWithCourses() {
        // 1. Create Student
        Student student = new Student();
        student.setName("Rohan Das");
        student.setEmail("rohan@example.com");

        // 2. Create Courses
        Course c1 = new Course();
        c1.setTitle("Java Spring Boot");
        c1.setFee(5000.0);

        Course c2 = new Course();
        c2.setTitle("React JS");
        c2.setFee(3000.0);

        // 3. Link them (Bidirectional) - DONO side add karna padega

        // Student ke list me courses daalo
        student.getCourses().add(c1);
        student.getCourses().add(c2);

        // Course ke list me student daalo
//        c1.getStudents().add(student);
//        c2.getStudents().add(student);

        // 4. Save Parent (Cascade ki wajah se courses aur join table apne aap ban jayenge)
        return studentRepository.save(student);
    }
}
