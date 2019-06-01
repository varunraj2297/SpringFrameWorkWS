package com.nt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("dao")
public class EmployeeDAOImpl implements EmployeeDAO {
	
    @Autowired
    private SimpleJdbcCall sjc;

	@Override
	public List<EmployeeBO> getEmpsByDesg(String desg) {
		List<EmployeeBO> listBos=null;
		sjc.returningResultSet("details",new BeanPropertyRowMapper(EmployeeBO.class));
		sjc.setProcedureName("p_getEmpsByDesg");
		listBos=sjc.executeObject(List.class, desg);
		return listBos;
	}
}