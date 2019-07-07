package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Basic;
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
	private String holderName;
	private String addrs;
	private float balance;
}
