package com.example.product.service;

import com.example.product.entity.AccessCard;
import com.example.product.entity.Employee;
import com.example.product.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployeeWithCard() {

        Employee emp = new Employee();
        emp.setName("Rahul Sharma");
        emp.setDesignation("Java Developer");

        AccessCard card = new AccessCard();
        card.setCardNumber("CARD-998877");
        card.setExpiryDate(LocalDate.now().plusYears(2));

        emp.setAccessCard(card);   // Parent -> Child
        card.setEmployee(emp);     // Child -> Parent

        return employeeRepository.save(emp);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        return emp.orElse(null);
    }
}
