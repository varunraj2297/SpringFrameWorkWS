package com.nt.controller;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;
import com.nt.vo.StudentVO;

public class StudentController {
	private StudentService service;

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
