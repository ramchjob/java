package com.myservice.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "role")
public class Role extends BaseObject {

   /**
    *
    */
   private static final long serialVersionUID = 548928915850698490L;

   @Id
   @Column(name = "ROLE_CD")
   private String roleCode;

   @JsonIgnore
   @Column(name = "ROLE_DESC")
   private String roleDesc;

   @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
   private List<EmployeeRole> employeeRoles;

   public String getRoleCode() {
      return roleCode;
   }

   public void setRoleCode(String roleCode) {
      this.roleCode = roleCode;
   }

   public String getRoleDesc() {
      return roleDesc;
   }

   public void setRoleDesc(String roleDesc) {
      this.roleDesc = roleDesc;
   }

}
