package com.nt.service;


import java.util.List;

import com.nt.dto.InsurancePolicyDTO;

public interface InsuranceService {
   public InsurancePolicyDTO findInsurancePolicyDetailsById(int id);
   public List<InsurancePolicyDTO> findInsurancePolicyDetailsByPolicyNames(String name1,String name2);
   public String register(InsurancePolicyDTO dto);
}