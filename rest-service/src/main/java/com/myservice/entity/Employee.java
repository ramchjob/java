package com.myservice.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "employee")
@NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
public class Employee extends BaseObject implements Serializable {
   private static final long serialVersionUID = 1L;

   @Id
   @Column(name = "EMP_ID")
   private String empId;

   @Temporal(TemporalType.DATE)
   @Column(name = "EMP_DOB")
   private Date empDob;

   @Column(name = "EMP_FIRST_NAME")
   private String empFirstName;

   @Column(name = "EMP_LAST_NAME")
   private String empLastName;

   @Temporal(TemporalType.DATE)
   @Column(name = "EMP_START_DT")
   private Date empStartDt;

   @Column(name = "EMP_WORK_EMAILID")
   private String empWorkEmailid;

   @Column(name = "STATUS_CODE")
   private String status;

   @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", cascade = CascadeType.ALL)
   @Fetch(FetchMode.SELECT)
   @JsonManagedReference
   private List<EmployeeRole> employeeRoles;

   public String getEmpId() {
      return this.empId;
   }

   public void setEmpId(String empId) {
      this.empId = empId;
   }

   public Date getEmpDob() {
      return this.empDob;
   }

   public void setEmpDob(Date empDob) {
      this.empDob = empDob;
   }

   public String getEmpFirstName() {
      return this.empFirstName;
   }

   public void setEmpFirstName(String empFirstName) {
      this.empFirstName = empFirstName;
   }

   public String getEmpLastName() {
      return this.empLastName;
   }

   public void setEmpLastName(String empLastName) {
      this.empLastName = empLastName;
   }

   public Date getEmpStartDt() {
      return this.empStartDt;
   }

   public void setEmpStartDt(Date empStartDt) {
      this.empStartDt = empStartDt;
   }

   public String getEmpWorkEmailid() {
      return this.empWorkEmailid;
   }

   public void setEmpWorkEmailid(String empWorkEmailid) {
      this.empWorkEmailid = empWorkEmailid;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public List<EmployeeRole> getEmployeeRoles() {
      return employeeRoles;
   }

   public void setEmployeeRoles(List<EmployeeRole> employeeRoles) {
      this.employeeRoles = employeeRoles;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      Employee other = (Employee) obj;

      if (empDob == null) {
         if (other.empDob != null) {
            return false;
         }
      }
      else if (!empDob.equals(other.empDob)) {
         return false;
      }

      if (empFirstName == null) {
         if (other.empFirstName != null) {
            return false;
         }
      }
      else if (!empFirstName.equals(other.empFirstName)) {
         return false;
      }
      if (empId == null) {
         if (other.empId != null) {
            return false;
         }
      }
      else if (!empId.equals(other.empId)) {
         return false;
      }

      if (empLastName == null) {
         if (other.empLastName != null) {
            return false;
         }
      }
      else if (!empLastName.equals(other.empLastName)) {
         return false;
      }

      if (empStartDt == null) {
         if (other.empStartDt != null) {
            return false;
         }
      }
      else if (!empStartDt.equals(other.empStartDt)) {
         return false;
      }
      if (empWorkEmailid == null) {
         if (other.empWorkEmailid != null) {
            return false;
         }
      }
      else if (!empWorkEmailid.equals(other.empWorkEmailid)) {
         return false;
      }

      return true;
   }

}