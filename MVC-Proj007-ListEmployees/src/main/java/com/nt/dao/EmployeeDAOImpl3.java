package com.nt.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("dao")
public class EmployeeDAOImpl3 implements EmployeeDAO {
	private static final String GET_EMP_BY_ID="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private static final String GET_EMPS_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB=?";
	private static final String GET_EMPS_BY_SALRANGE="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE SAL BETWEEN ? AND ?";
	
    @Autowired
    private JdbcTemplate jt;

	public EmployeeBO getEmpById(int eno) {
		EmployeeBO bo1=null;
		
		bo1=jt.queryForObject(GET_EMP_BY_ID,
				 new BeanPropertyRowMapper<EmployeeBO>(EmployeeBO.class),
				eno);
		return bo1;
	}

	@Override
	public List<EmployeeBO> getEmpsByDesg(String desg) {
		List<EmployeeBO> listBo=null;
		RowMapper<EmployeeBO> rowmapper=null;
		rowmapper=new BeanPropertyRowMapper<EmployeeBO>(EmployeeBO.class);
		listBo=jt.query(GET_EMPS_BY_DESG,rowmapper, desg);
		return listBo;
	}

	@Override
	public List<EmployeeBO> getEmpsBySalRange(int startSal, int endSal) {
		List<EmployeeBO> listBo=null;
		RowMapper<EmployeeBO> rowmapper=null;
		rowmapper=new BeanPropertyRowMapper<EmployeeBO>(EmployeeBO.class);
		listBo=jt.query(GET_EMPS_BY_SALRANGE,rowmapper, startSal,endSal);
		return listBo;
	}
}
