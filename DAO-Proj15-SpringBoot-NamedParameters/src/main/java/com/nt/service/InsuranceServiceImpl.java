package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.InsurancePolicyBO;
import com.nt.dao.InsurancePolicyDAO;
import com.nt.dto.InsurancePolicyDTO;


@Service("service")
public class InsuranceServiceImpl implements InsuranceService{

	@Autowired
	private InsurancePolicyDAO dao;

	@Override
	public InsurancePolicyDTO findInsurancePolicyDetailsById(int id) {
		InsurancePolicyDTO dto=null;
		InsurancePolicyBO bo=null;
		dto=new InsurancePolicyDTO();
		bo=dao.getInsurancePolicyDetailsById(id);
		BeanUtils.copyProperties(bo,dto);
		return dto;
	}

	@Override
	public List<InsurancePolicyDTO> findInsurancePolicyDetailsByPolicyNames(String name1, String name2) {
		List<InsurancePolicyDTO> listDtos=new ArrayList<InsurancePolicyDTO>();
		List<InsurancePolicyBO> listBos=null;
		
		listBos=dao.getInsurancePolicyDetailsByPolicyNames(name1, name2);
		listBos.forEach(bo->{
			InsurancePolicyDTO dto=new InsurancePolicyDTO();
			BeanUtils.copyProperties(bo,dto);
			listDtos.add(dto);
		});
		return listDtos;
	}

	@Override
	public String register(InsurancePolicyDTO dto) {
		
		int result=0;
		InsurancePolicyBO bo=new InsurancePolicyBO();
		BeanUtils.copyProperties(dto,bo);
		result=dao.insert(bo);
         
		return result==0?"failed":"success";

	}
	
	
	
	

	
}
