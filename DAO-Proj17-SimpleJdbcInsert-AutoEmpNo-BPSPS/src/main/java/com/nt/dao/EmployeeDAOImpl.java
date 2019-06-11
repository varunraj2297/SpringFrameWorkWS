package com.nt.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;
import com.nt.test.JdbcTemplateTest;

@Repository("dao")
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String GET_EMPNO="SELECT EMPNO_SEQ.NEXTVAL FROM DUAL";
	
    @Autowired
    private SimpleJdbcInsert sji;
    
    private int getAutoEmpNo() {
		int count=0;
		JdbcTemplate template=sji.getJdbcTemplate();
        count=template.queryForObject(GET_EMPNO, Integer.class);
    	return count;
    }
    
    @Override
	public int insert1(EmployeeBO bo) {
		int count=0;
		Map<String,Object> map=null;
		map=new HashMap<String,Object>();
		map.put("EMPNO", bo.getEmpNo());
		map.put("ENAME", bo.getEname());
		map.put("JOB", bo.getJob());
		map.put("SAL",bo.getSal());
		
		//sji.setTableName("EMP1");
		count=sji.execute(map);
		return count;
	}

	@Override
	public int insert2(EmployeeBO bo) {
		int count=0;
		BeanPropertySqlParameterSource bpsps=null;
		
		bo.setEmpNo(getAutoEmpNo());
		bpsps=new BeanPropertySqlParameterSource(bo);
		
		sji.setTableName("EMP1");
		count=sji.execute(bpsps);
		return count;
	}
}
