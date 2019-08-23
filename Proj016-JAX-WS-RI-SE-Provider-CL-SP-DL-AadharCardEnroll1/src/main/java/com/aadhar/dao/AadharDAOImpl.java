package com.aadhar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aadhar.entity.AadharEntity;

//@Repository("aadharDao")
public class AadharDAOImpl implements AadharDAO{
	//@Autowired
	private HibernateTemplate ht;
	
	public AadharDAOImpl(HibernateTemplate ht) {
		this.ht = ht;
	}

	@Override
	public long enrollApplicant(AadharEntity aadharEntity) throws Exception {
		long aadharNo=0;
		ht.setCheckWriteOperations(false);
		aadharNo=(long)ht.save("AadharEntity",aadharEntity);
		return aadharNo;
	}

	@Override
	public AadharEntity getAadharDetailsById(long aadharNo) throws Exception {
		 return ht.get(AadharEntity.class, aadharNo);
	}

}
