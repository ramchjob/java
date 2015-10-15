package com.myservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myservice.dao.EmployeeDao;
import com.myservice.entity.Employee;
import com.myservice.model.Numbers;

@Service
@Transactional
public class MyService {

   @Autowired
   private EmployeeDao employeeDao;

   Numbers myNumbers = new Numbers();

   @GET
   @Path("/numbers")
   @Produces(MediaType.APPLICATION_JSON)
   public Numbers getNumbers(@QueryParam("startNumber") int startNumber) {
      List<Integer> numbers = new ArrayList<Integer>();
      for (int i = startNumber; i < startNumber + 100; i++) {

         numbers.add(i);
      }
      myNumbers.setNumbers(numbers);
      return myNumbers;
   }

   @GET
   @Path("/employee")
   @Produces({ MediaType.APPLICATION_JSON })
   public Employee getEmployee(@QueryParam("employeeId") String employeeId) {
      Employee emp = employeeDao.getById(employeeId);
      return emp;
   }

}
