package com.aadhar.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@Table(name="AADHAR_DETAILS")
public class AadharEntity{
	  @Id
	  @SequenceGenerator(name="gen1",initialValue=626184123,allocationSize=1,sequenceName="AADHAR_SEQ")
	  @GeneratedValue(generator="gen1")
	  @Column(name="AADHAR_NO",length=9)
	  @Type(type="long")
	  private long aadharNo; 
	  @Column(name="FIRST_NAME",length=15)
	  @Type(type="string")
      private String firstName;
	  @Column(name="LAST_NAME",length=15)
	  @Type(type="string")
      private String lastName;
	  @Column(name="GENDER",length=6)
	  @Type(type="string")
      private String gender;
	  @Column(name="DOB")
	  @Type(type="date")
      private Date dob;
	  @Column(name="PINCODE",length=6)
	  @Type(type="int")
      private int pinCode;
      
	 public AadharEntity() {
		System.out.println("AadharEntity-no-param constructor");
	 }
	 
}
