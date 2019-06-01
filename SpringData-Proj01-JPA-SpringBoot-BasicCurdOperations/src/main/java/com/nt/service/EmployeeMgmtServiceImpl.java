package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dto.EmployeeDTO;
import com.nt.entity.EmployeeEntity;
import com.nt.repository.EmployeeRepository;

@Service("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService{

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		
		List<EmployeeEntity> empsEntityList=null;
		
		List<EmployeeDTO> empsDTOList=new ArrayList<EmployeeDTO>();
		empsEntityList=(List<EmployeeEntity>)empRepo.findAll();
		
		empsEntityList.forEach(emp ->{
		   EmployeeDTO dto=new EmployeeDTO();
		   BeanUtils.copyProperties(emp, dto);
		   empsDTOList.add(dto);
		});
		return empsDTOList;
	}

	@Override
	public EmployeeDTO getEmployeeById(int eno) {
		Optional<EmployeeEntity> optEntity=null;
		EmployeeEntity entity=null;
		EmployeeDTO dto=null;
		
		optEntity=empRepo.findById(eno);
		entity=optEntity.get();
		dto=new EmployeeDTO();
		
		BeanUtils.copyProperties(entity,dto);
		
		return dto;
	}

	@Override
	public List<EmployeeDTO> getEmpsByDesg(String desg1,String desg2) {
		List<EmployeeEntity> listEntities=null;
		List<EmployeeDTO> listDtos=new ArrayList<EmployeeDTO>();
		
		listEntities=empRepo.findEmpsByDesgs(desg1,desg2);
		listEntities.forEach(entity->{
		   EmployeeDTO dto=new EmployeeDTO();
		   BeanUtils.copyProperties(entity,dto);
	       listDtos.add(dto);
		});
		return listDtos;
	}

	@Override
	public long getEmpsCount() {
		long count=empRepo.count();
		return count;
	}

	@Override
	public long getEmpsSalariesTotal() {
		long totalSal=empRepo.findEmpsSalariesTotal();
		return totalSal;
	}

	@Override
	public String registerEmployee(EmployeeDTO dto) {
		EmployeeEntity empEntity=new EmployeeEntity();
		BeanUtils.copyProperties(dto,empEntity);
		empEntity=empRepo.save(empEntity);
		
		if(empEntity==null)
			return "Employee Not Registered";
		else
			return "Employee Registered";
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public String addBonusToEmpsByDesg(float bonus, String desg) {
		int count=0;
		count=empRepo.rewardBonusToEmpsByDesg(bonus,desg);
		return count+" records is/are updated";
	}
}