package com.nt.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.nt.bo.EmployeeBO;
import com.nt.bo.StudentBO;
import com.nt.dao.DAO;
import com.nt.dto.EmployeeDTO;
import com.nt.dto.StudentDTO;

public abstract class Service {
	private DAO dao;
	private String result;
	private int count;
	
	
	public Service(DAO dao) {
		this.dao = dao;	
	}
	
	public abstract StudentBO createStudentBO();
	public abstract EmployeeBO createEmployeeBO();
	
	
	public String registerStudent(StudentDTO dto) {
		StudentBO bo=createStudentBO();
		BeanUtils.copyProperties(dto,bo);
		int count=dao.insertStudent(bo);
		if(count==0)
			result="Student Registration Failed";
		else
			result="Student Registration Succeded";
		
		return result;
	}
	
	public String registerEmployee(EmployeeDTO dto) {
		EmployeeBO bo=createEmployeeBO();
		BeanUtils.copyProperties(dto,bo);
		
		int count=dao.insertEmployee(bo);
		if(count==0)
			result="Employee Registration Failed";
		else
			result="Employee Registration Succeded";
		
		return result;
	}
	
	
}
