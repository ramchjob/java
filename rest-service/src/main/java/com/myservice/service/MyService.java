package com.myservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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
   public Response saveEmployee(@RequestBody Employee employee) {

      LOGGER.debug("Request received for employee creation with employee first name "
            + employee.getEmpFirstName());

      try {
         String empId = employeeService.createEmployee(employee);
         LOGGER.debug("employee created with employee ID  " + empId);
      }
      catch (Exception e) {
         LOGGER.debug("Excpetion while creating new employee " + e.getCause().getMessage());

         return Response.status(Status.BAD_REQUEST).build();
      }
      return Response.status(Status.CREATED).build();

   }

   @PUT
   @Path("/employee")
   @Consumes({ MediaType.APPLICATION_JSON })
   public Response updateEmployee(@RequestBody Employee employee) {

      LOGGER.debug("Request received for employee updation with employee first name "
            + employee.getEmpFirstName());

      try {
         employeeService.updateEmployee(employee);
         LOGGER.debug("employee updated with employee ID  " + employee.getEmpId());
      }
      catch (Exception e) {
         LOGGER.debug("Excpetion while creating new employee " + e.getCause().getMessage());

         return Response.status(Status.BAD_REQUEST).build();
      }
      return Response.status(Status.OK).build();

   }

   @DELETE
   @Path("/employee")
   public Response deleteEmployee(@QueryParam("employeeId") String employeeId) {

      LOGGER.debug("Request received for employee deletion with employee id " + employeeId);

      try {
         employeeService.deleteEmployee(employeeId);
         LOGGER.debug("employee deleted with employee ID  " + employeeId);
      }
      catch (Exception e) {
         LOGGER.debug("Excpetion while creating new employee " + e.getCause().getMessage());

         return Response.status(Status.BAD_REQUEST).build();
      }
      return Response.status(Status.OK).build();

   }
}
