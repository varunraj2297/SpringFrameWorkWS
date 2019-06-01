package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
	private JdbcTemplate jt;
	
	@Override
	public List<Map<String, Object>> getEmpDetailsByDesgs(String condition) {
		List<Map<String, Object>> empsList=null;
		
		empsList=jt.queryForList("SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN("+condition+")");
		
		return empsList;
				
	}

}
