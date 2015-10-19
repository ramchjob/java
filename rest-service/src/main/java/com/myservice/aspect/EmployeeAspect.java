package com.myservice.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAspect {

   @Before("execution(* getEmployee(..)) && args(param) ")
   public void validateAdvice(String param) {

      if (param != null) {
         System.out.println("Executing Before Advice on getEmployee() for employeeID :: " + param);
      }

   }
}