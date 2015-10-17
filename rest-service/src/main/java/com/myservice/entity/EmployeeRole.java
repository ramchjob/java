/**
 *
 */
package com.myservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author Rchimata
 *
 */
@Entity
@Table(name = "employee_roles")
public class EmployeeRole extends BaseObject {

   /**
    *
    */
   private static final long serialVersionUID = -4283218403552610327L;

   @Id
   @Column(name = "EMP_ROLE_ID")
   @GenericGenerator(name = "Idgenrole", strategy = "increment")
   @GeneratedValue(generator = "Idgenrole")
   private int employeeRoleId;

   @ManyToOne
   @JoinColumn(name = "EMPLOYEE_ID")
   @JsonBackReference
   private Employee employee;

   @ManyToOne
   @JoinColumn(name = "EMPLOYEE_ROLE")
   private Role role;

   public int getEmployeeRoleId() {
      return employeeRoleId;
   }

   public void setEmployeeRoleId(int employeeRoleId) {
      this.employeeRoleId = employeeRoleId;
   }

   public Employee getEmployee() {
      return employee;
   }

   public void setEmployee(Employee employee) {
      this.employee = employee;
   }

   public Role getRole() {
      return role;
   }

   public void setRole(Role role) {
      this.role = role;
   }

}
