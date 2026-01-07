package com.example.product.controller;

import com.example.product.entity.Employee;
import com.example.product.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create-with-card")
    public ResponseEntity<Employee> createEmployee() {

        Employee savedEmployee = employeeService.createEmployeeWithCard();
        return ResponseEntity.ok(savedEmployee);
    }

    // Get ALL Employees
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> list = employeeService.getAllEmployees();
        return ResponseEntity.ok(list);
    }

    // Get Single Employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee emp = employeeService.getEmployeeById(id);

        if (emp != null) {
            return ResponseEntity.ok(emp);
        } else {
            return ResponseEntity.notFound().build(); // 404 Error if ID is False.
        }
    }

}
