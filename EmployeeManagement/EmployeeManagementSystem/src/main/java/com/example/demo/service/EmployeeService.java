package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Employee;
//service layer
public interface EmployeeService {
    void save(Employee employee);
    List<Employee> getAll();
    
    
}
