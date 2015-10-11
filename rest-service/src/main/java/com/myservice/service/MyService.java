package com.myservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.myservice.model.Numbers;

public class MyService {

   Numbers myNumbers = new Numbers();

   @GET
   @Path("/numbers")
   @Produces(MediaType.APPLICATION_JSON)
   public Numbers getNumbers(
         @QueryParam("startNumber") int startNumber) {
      List<Integer> numbers = new ArrayList<Integer>();
      for (int i = startNumber; i < startNumber + 100; i++) {

         numbers.add(i);
      }
      myNumbers.setNumbers(numbers);
      return myNumbers;
   }
}
