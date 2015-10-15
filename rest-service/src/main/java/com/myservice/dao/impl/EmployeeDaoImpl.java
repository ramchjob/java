package com.myservice.dao.impl;

import org.springframework.stereotype.Repository;

import com.myservice.dao.EmployeeDao;
import com.myservice.entity.Employee;
import com.myservice.generic.dao.impl.GenericDaoImpl;

@Repository
public class EmployeeDaoImpl extends GenericDaoImpl<Employee, String> implements EmployeeDao {

   @Override
   protected Class<Employee> getEntityClass() {
      return Employee.class;
   }

   public String getEmpId(String cond) {
      // TODO Auto-generated method stub
      return null;
   }

}
