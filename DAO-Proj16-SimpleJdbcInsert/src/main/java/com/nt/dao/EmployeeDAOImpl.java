package com.nt.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("dao")
public class EmployeeDAOImpl implements EmployeeDAO {
	
    @Autowired
    private SimpleJdbcInsert sji;

	@Override
	public int insert(EmployeeBO bo) {
		int count=0;
		Map<String,Object> map=null;
		map=new HashMap<String,Object>();
		map.put("EMPNO", bo.getEmpNo());
		map.put("ENAME", bo.getEname());
		map.put("JOB", bo.getJob());
		map.put("SAL",bo.getSal());
		
		sji.setTableName("EMP1");
		count=sji.execute(map);
		return count;
	}
}
