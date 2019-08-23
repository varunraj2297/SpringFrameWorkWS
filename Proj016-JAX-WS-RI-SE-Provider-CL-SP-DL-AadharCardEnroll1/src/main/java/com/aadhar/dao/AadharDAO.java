package com.aadhar.dao;

import com.aadhar.entity.AadharEntity;

public interface AadharDAO {
     public long enrollApplicant(AadharEntity aadharEntity) throws Exception;
     public AadharEntity getAadharDetailsById(long aadharNo) throws Exception;
}
