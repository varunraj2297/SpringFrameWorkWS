package com.aadhar.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aadhar.dao.AadharDAO;
import com.aadhar.dto.AadharDTO;
import com.aadhar.entity.AadharEntity;

//@Service("aadharService")
@WebService(endpointInterface="com.aadhar.service.AadharService")
public class AadharServiceImpl implements AadharService{

	//@Autowired
	private AadharDAO aadharDao;
	
	public AadharServiceImpl(AadharDAO aadharDao) {
		this.aadharDao = aadharDao;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@WebMethod(exclude=true)
	public String registerApplicant(AadharDTO aadharDTO) throws Exception {
		AadharEntity aadharEntity=null;
		long aadharNo=0;
		
		aadharEntity=new AadharEntity();
		BeanUtils.copyProperties(aadharDTO, aadharEntity);
		aadharNo=aadharDao.enrollApplicant(aadharEntity);
		return (aadharNo!=0)?"Aadhar card enrollement is successfull ,your aadhar number is "+aadharNo:"Aadhar card enrollement is failed";
	}

	@Override
	public AadharDTO fetchPersonDetailsById(long aadharNo) throws Exception {
		AadharEntity aadharEntity=null;
		AadharDTO aadharDTO=null;
		
		aadharEntity=aadharDao.getAadharDetailsById(aadharNo);
		aadharDTO=new AadharDTO();
		BeanUtils.copyProperties( aadharEntity,aadharDTO);
		return aadharDTO;
	}

}
