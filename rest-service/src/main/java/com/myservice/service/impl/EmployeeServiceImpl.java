package com.myservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myservice.dao.EmployeeDao;
import com.myservice.entity.Employee;
import com.myservice.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

   @Autowired
   private EmployeeDao employeeDao;

   public Employee getEmployeeById(String employeeId) {

      return employeeDao.getById(employeeId);
   }

   public String createEmployee(Employee employee) {

      return employeeDao.save(employee);
   }

}
