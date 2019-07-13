package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import com.nt.bo.EmployeeBO;
import com.nt.bo.ResultEmployeeBO;


public class EmployeeSearchDAOImpl implements EmployeeSearchDAO {

	/*private static final String GET_EMP_BY_SEARCH = "SELECT EMPNO,ENAME,JOB,SAL,MGR,DEPTNO FROM EMP"
			+ " WHERE EMPNO IS NOT NULL AND EMPNO=? " + " OR ENAME IS NOT NULL AND ENAME=? "
			+ " OR JOB IS NOT NULL AND JOB=?" + " OR SAL IS NOT NULL AND SAL=?";
	*/
	
	private static final String GET_EMP_BY_SEARCH = "SELECT EMPNO as eno,ENAME,JOB as desg,SAL as salary,MGR,DEPTNO FROM EMP WHERE EMPNO=? OR ENAME=? OR JOB=? OR  SAL=?";

	private JdbcTemplate jt;

	public EmployeeSearchDAOImpl(JdbcTemplate jt) {
		System.out.println("EmployeeSearchDAOImpl-1-param-constructor");
		this.jt = jt;
	}

	@Override
	public List<ResultEmployeeBO> findEmps(EmployeeBO bo) {
		List<ResultEmployeeBO> resultlist = null;
		BeanPropertyRowMapper<ResultEmployeeBO> rowMapper=null; 
		
		/*resultlist = jt.query(GET_EMP_BY_SEARCH, new EmployeeSearchRowMapper(), bo.getEno(), bo.getEname(),
				bo.getDesg(), bo.getSalary());*/
		rowMapper=new BeanPropertyRowMapper(ResultEmployeeBO.class);
		resultlist=(List<ResultEmployeeBO>) jt.query(GET_EMP_BY_SEARCH,new RowMapperResultSetExtractor(rowMapper),bo.getEno(),bo.getEname(),bo.getDesg(),bo.getSalary());
		return resultlist;
	}

	/*private static class EmployeeSearchRowMapper implements RowMapper<ResultEmployeeBO> {
	
		@Override
		public ResultEmployeeBO mapRow(ResultSet rs, int rowNum) throws SQLException {
	
			ResultEmployeeBO rEmpBo = new ResultEmployeeBO();
			rEmpBo.setEno(rs.getInt(1));
			rEmpBo.setEname(rs.getString(2));
			rEmpBo.setDesg(rs.getString(3));
			rEmpBo.setSalary(rs.getInt(4));
			rEmpBo.setMgr(rs.getInt(5));
			rEmpBo.setDeptno(rs.getInt(6));
			return rEmpBo;
		}
	
	}*/

}
