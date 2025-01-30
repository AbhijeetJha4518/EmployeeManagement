package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.example.demo.EmployeeRepository;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void save(Employee employee) {
        log.info("Saving employee: {}", employee);
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        log.info("Fetching all employees");
        return employeeRepository.findAll();
    }

	@Override
	public String delete(int empId) {
		
		log.info("Deleting Employee");
		employeeRepository.deleteById(empId);
		return "Employee Deleted Successfully...!!!!";
	}

	@Override
    public void update(int empId, Employee employee) {
        log.info("Updating employee with Id: {}", empId);
        Employee existingEmployee = employeeRepository.findById(empId).orElseThrow(() -> new RuntimeException("Employee not found"));
        existingEmployee.setName(employee.getName());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setSalary(employee.getSalary());
        employeeRepository.save(existingEmployee);
    }


}
