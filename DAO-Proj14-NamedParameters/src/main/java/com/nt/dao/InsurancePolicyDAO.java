package com.nt.dao;

import java.util.List;

import com.nt.bo.InsurancePolicyBO;

public interface InsurancePolicyDAO {
    public InsurancePolicyBO getInsurancePolicyDetailsById(int id);
    public List<InsurancePolicyBO> getInsurancePolicyDetailsByPolicyNames(String name1,String name2);
    public int insert(InsurancePolicyBO bo);
}
