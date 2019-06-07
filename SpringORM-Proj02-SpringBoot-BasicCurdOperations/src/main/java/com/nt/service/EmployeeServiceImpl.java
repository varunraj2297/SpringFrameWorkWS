package com.nt.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;
import com.nt.entity.EmployeeHLO;

@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
	private EmployeeDAO dao;
    
	public EmployeeDTO fetchEmpByEno(int eno)  throws Exception{
		EmployeeHLO hlo=null;
		EmployeeDTO dto=null;
		dto=new EmployeeDTO();
		hlo=dao.getEmpByEno(eno);
		BeanUtils.copyProperties(hlo, dto);
		return dto;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,transactionManager="hbTxMgr",readOnly=false)
	public String registerEmp(EmployeeDTO dto) {
		EmployeeHLO hlo=null;
		int idVal=0;
		hlo=new EmployeeHLO();
		BeanUtils.copyProperties(dto,hlo);
		idVal=dao.insertEmp(hlo);
	    return "Employee Registered with "+idVal;
	}

	@Override
	public float findEmpSalById(int eno) {
		/*float sal=0.0f;
		sal=dao.getEmpSalById(eno);
		return sal;*/
		return dao.getEmpSalById(eno);
	}


	/*@Override
	@Transactional(propagation=Propagation.REQUIRED,transactionManager="hbTxMgr",readOnly=false)
	public String hikeEmpSalById(int eno, float percentage) {
		int count=0;
		count=dao.updateEmpSalById(eno, percentage);
		if(count==0)
			return "Employee salary is not updated";
		else
			return "Employee salary is updated";
	}*/
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,transactionManager="hbTxMgr",readOnly=false)
	public String hikeEmpSalById(int eno, float percentage) {
		int count=0;
		float sal=0.0f,newSal=0.0f;
		
		sal=dao.getEmpSalById(eno);
		newSal=sal+sal*(percentage/100.0f);
		count=dao.updateEmpSalById(eno, newSal);
		if(count==0)
			return "Employee salary is not updated";
		else
			return "Employee salary is updated";
	}

	@Override
	//@Transactional(propagation=Propagation.REQUIRED,transactionManager="hbTxMgr",readOnly=false)
	public String ression(float minSal, float maxSal) {
		int count=0;
		count=dao.deleteEmpsBySalRange(minSal, maxSal);
		return count+" no. of employees are fired";
	}

}
