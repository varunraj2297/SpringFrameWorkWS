package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;
@Service("service")
@DependsOn("dao")
@Scope("singleton")
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDAO dao;
	
	

	public StudentServiceImpl() {
		System.out.println("StudentServiceImpl 0-param con");
	}


	public StudentServiceImpl(StudentDAO dao) {
		this.dao = dao;
	}


	@Override
	public String generateResult(StudentDTO dto) throws Exception {
		// TODO Auto-generated method stub
		int total=0;
		float avg=0.0f;
		String result=null;
		int count=0;
		
		total=dto.getM1()+dto.getM2()+dto.getM3();
		avg=total/3.0f;
		if(dto.getM1()>35 && dto.getM2()>35 && dto.getM3()>35)
			result="passed";
		else
			result="failed";
		
		StudentBO bo=new StudentBO();
		
		bo.setSname(dto.getSname());
		bo.setSadd(dto.getSadd());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		
		count=dao.insert(bo);
		if(count==0)
			return "REGISTRATION FAILED "+result;
		else
			return "REGISTRATION SUCCESSFULL "+result;
		
	}

}
