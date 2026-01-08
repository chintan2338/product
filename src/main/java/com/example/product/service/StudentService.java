package com.example.product.service;

import com.example.product.dto.StudentRequestDTO;
import com.example.product.entity.Course;
import com.example.product.entity.Student;
import com.example.product.repository.CourseRepository;
import com.example.product.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Student enrollStudent(StudentRequestDTO dto) {
        // 1. Make Naya Student object
        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());

        // 2. Database se saare requested courses fetch karein
        List<Course> selectedCourses = courseRepository.findAllById(dto.getCourseIds());

        // 3. Bidirectional Linking
        for (Course course : selectedCourses) {
            student.getCourses().add(course);      // Student ko course diya
            course.getStudents().add(student);    // Course ko student diya
        }

        // 4. Save Student
        return studentRepository.save(student);
    }
}
