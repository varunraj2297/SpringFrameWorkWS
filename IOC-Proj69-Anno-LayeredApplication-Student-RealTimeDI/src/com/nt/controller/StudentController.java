package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;
import com.nt.vo.StudentVO;
@Controller("controller")
@DependsOn("service")
@Scope("singleton")			//by default singleton
public class StudentController {
	@Autowired
	private StudentService service;
	
	

	public StudentController() {
		System.out.println("StudentController 0-param con");
	}

	public StudentController(StudentService service) {
		this.service = service;
	}
	
	public String process(StudentVO vo) throws Exception{
		String result=null;
		

		StudentDTO dto=new StudentDTO();
		dto.setSname(vo.getSname());
		dto.setSadd(vo.getSadd());
		dto.setM1(Integer.parseInt(vo.getM1()));
		dto.setM2(Integer.parseInt(vo.getM2()));
		dto.setM3(Integer.parseInt(vo.getM3()));
		result=service.generateResult(dto);
		return result;
	}
	
}
