package com.myservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "employee_status")
@NamedQuery(name = "EmployeeStatus.findAll", query = "SELECT e FROM EmployeeStatus e")
public class EmployeeStatus extends BaseObject {

   /**
    *
    */
   private static final long serialVersionUID = 1L;

   @Id
   @Column(name = "STATUS_CODE")
   private String statusCode;

   @Column(name = "STATUS_DESC")
   private String statusDesc;

   public String getStatusCode() {
      return statusCode;
   }

   public void setStatusCode(String statusCode) {
      this.statusCode = statusCode;
   }

   public String getStatusDesc() {
      return statusDesc;
   }

   public void setStatusDesc(String statusDesc) {
      this.statusDesc = statusDesc;
   }

}
