package com.nt.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.InsurancePolicyBO;

@Repository("dao")
public class InsurancePolicyDAOImpl implements InsurancePolicyDAO {
	private static final String GET_INSURANCE_DETAILS_BY_ID="SELECT INSURANCEID,INSURANCENAME,INITIALAMOUNT,TENURE FROM INSURANCEPOLICY WHERE INSURANCEID=:ipid";
	private static final String GET_INSURANCE_DETAILS_BY_POLICYNAMES="SELECT INSURANCEID,INSURANCENAME,INITIALAMOUNT,TENURE FROM INSURANCEPOLICY WHERE INSURANCENAME IN(:name1,:name2)";
	private static final String INSERT_QUERY="INSERT INTO INSURANCEPOLICY VALUES(:ipid,:ipName,:initialAmount,:tenure)";
	
    @Autowired
    private NamedParameterJdbcTemplate npjt;

	@Override
	public InsurancePolicyBO getInsurancePolicyDetailsById(int id) {
		Map<String,Integer> paramMap=new HashMap<String,Integer>();
		InsurancePolicyBO bo=null;
		paramMap.put("ipid",id);
		
		bo=npjt.queryForObject(GET_INSURANCE_DETAILS_BY_ID, paramMap, 
			         (rs,rowNum)->{
			        	 InsurancePolicyBO bo1=new InsurancePolicyBO();
			        	 bo1.setIpid(rs.getInt(1));
			        	 bo1.setIpName(rs.getString(2));
			        	 bo1.setInitialAmount(rs.getInt(3));
			        	 bo1.setTenure(rs.getInt(4));
			        	 return bo1;
			         });            
		return bo;
	}

	@Override
	public List<InsurancePolicyBO> getInsurancePolicyDetailsByPolicyNames(String name1, String name2) {
		List<InsurancePolicyBO> listBos=null;
		MapSqlParameterSource msps=null;
		
		msps=new MapSqlParameterSource();
		msps.addValue("name1",name1);
		msps.addValue("name2",name2);
		
		listBos=npjt.query(GET_INSURANCE_DETAILS_BY_POLICYNAMES,msps,
				            rs->{
				            	List<InsurancePolicyBO> listBos1=new ArrayList<InsurancePolicyBO>();
				            	while(rs.next()) {	
				            	   InsurancePolicyBO bo=new InsurancePolicyBO();
				            	   bo.setIpid(rs.getInt(1));
				            	   bo.setIpName(rs.getString(2));
				            	   bo.setInitialAmount(rs.getInt(3));
				            	   bo.setTenure(rs.getInt(4));
				            	   listBos1.add(bo);
				            	}
				            	return listBos1;
				            });
		return listBos;
	}

	@Override
	public int insert(InsurancePolicyBO bo) {
		int count=0;
		count=npjt.update(INSERT_QUERY,new BeanPropertySqlParameterSource(bo));
		return count;
	}
}
