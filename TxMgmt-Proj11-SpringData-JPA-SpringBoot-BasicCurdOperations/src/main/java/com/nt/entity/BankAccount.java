package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="BANKACCOUNT")
public class BankAccount implements Serializable {
	@Id
	private int acno;
	//private String holderName;  //Problem::In db table new column is creating named "holder_name" , if we are taking capital N
	private String holdername;
	private String addrs;
	private float balance;
}
