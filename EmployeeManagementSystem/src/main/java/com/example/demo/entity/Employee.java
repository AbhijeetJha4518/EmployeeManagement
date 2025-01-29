package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Employee {
	@Id
	private int empid;
	private String empName;
	private String empSal;
	private String empRole;
	
}
