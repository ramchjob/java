package com.boot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = "applicationContext.xml")
public class BootApplication {

   public static void main(String[] args) {

      SpringApplication.run(BootApplication.class, args);
      System.out.println("Wassup!!!!");
   }

}
