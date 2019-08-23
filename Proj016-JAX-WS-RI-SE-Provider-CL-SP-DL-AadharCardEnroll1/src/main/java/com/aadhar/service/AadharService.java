package com.aadhar.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.aadhar.dto.AadharDTO;

@WebService(name="AadharService")
public interface AadharService {
	
     public  String registerApplicant(AadharDTO aadharDTO) throws Exception;
     
	@WebMethod(operationName="fetchPersonDetailsById")
	public @WebResult AadharDTO fetchPersonDetailsById(@WebParam long aadharNo) throws Exception;
}
