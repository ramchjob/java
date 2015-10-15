package com.myservice.dao;

import org.springframework.stereotype.Repository;

import com.myservice.entity.Employee;
import com.myservice.generic.dao.GenericDao;

@Repository
public interface EmployeeDao extends GenericDao<Employee, String> {

}
