package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/emp")
@AllArgsConstructor
public class EmployeeController {
	
	EmployeeService employeeService;
	
	@PostMapping("/add")
	public void addEmployee(@RequestBody Employee emp) {
		employeeService.save(emp);
	}
	
	
	@GetMapping("/all")
	public List<Employee> getAllEmployee(){
		return employeeService.getAll();
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable("id") int empId)
	{
		employeeService.delete(empId);
		return"Employee with Id "+empId+"deleted....!";
	}
	  @PutMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") int empId, @RequestBody Employee emp) {
        employeeService.update(empId, emp);
        return "Employee with Id " + empId + " updated....!";
    }
}
