package com.myservice.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class BaseObject implements Serializable {

   private static final long serialVersionUID = 1L;

   @Column(name = "CREATED_BY")
   private String createdBy;

   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "CREATED_DATE")
   private Date createdDate;

   @Column(name = "MODIFIED_BY")
   private String modifiedBy;

   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "MODIFIED_DATE")
   private Date modifiedDate;

   public String getCreatedBy() {
      return createdBy;
   }

   public void setCreatedBy(String createdBy) {
      this.createdBy = createdBy;
   }

   public Date getCreatedDate() {
      return createdDate;
   }

   public void setCreatedDate(Date createdDate) {
      this.createdDate = createdDate;
   }

   public String getModifiedBy() {
      return modifiedBy;
   }

   public void setModifiedBy(String modifiedBy) {
      this.modifiedBy = modifiedBy;
   }

   public Date getModifiedDate() {
      return modifiedDate;
   }

   public void setModifiedDate(Date modifiedDate) {
      this.modifiedDate = modifiedDate;
   }

}
