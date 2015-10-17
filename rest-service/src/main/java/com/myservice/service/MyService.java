package com.myservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.myservice.entity.Employee;
import com.myservice.model.Numbers;

@Component
public class MyService {
   private static final Logger LOGGER = Logger.getLogger(MyService.class);
   @Autowired
   private EmployeeService employeeService;

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
      LOGGER.debug("Request received to retrieve employee with id " + employeeId);
      Employee emp = employeeService.getEmployeeById(employeeId);

      return emp;
   }

   @POST
   @Path("/employee")
   @Consumes({ MediaType.APPLICATION_JSON })
   public String saveEmployee(@RequestBody Employee employee) {
      LOGGER.debug("Request received for employee creation with employee first name "
            + employee.getEmpFirstName());
      String empId = employeeService.createEmployee(employee);
      return empId;
   }

}
