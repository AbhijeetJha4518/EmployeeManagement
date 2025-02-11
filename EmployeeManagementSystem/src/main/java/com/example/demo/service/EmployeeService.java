package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Employee;

public interface EmployeeService {
    void save(Employee employee);
    List<Employee> getAll();
    
    public abstract String delete(int empId);
        void update(int empId, Employee employee);

}
