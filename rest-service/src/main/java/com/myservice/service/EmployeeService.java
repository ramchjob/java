package com.myservice.service;

import com.myservice.entity.Employee;

public interface EmployeeService {

   Employee getEmployeeById(String employeeId);

   String createEmployee(Employee employee);
}
