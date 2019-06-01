package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Data
@Table(name="EMP")
public class EmployeeEntity {
	@Id
    @Column(name="EMPNO")
	private int eid;
	private String ename;
	@Column(name="JOB")
	private String desg;
    private float sal;
}