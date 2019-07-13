package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.nt.bo.EmployeeBO;


public class EmployeeDAOImpl02 implements EmployeeDAO {
	
	private static final String GET_EMP_BY_ID="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private static final String GET_EMPS_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB=?";
	private static final String GET_EMPS_BY_SALRANGE="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE SAL>=? and SAL<=?";
	private static final String GET_EMPS="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP";
  
    private JdbcTemplate jt;

    
	public EmployeeDAOImpl02(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public EmployeeBO getEmpById(int eno) {
		EmployeeBO bo=null;
		
		bo=jt.queryForObject(GET_EMP_BY_ID,new EmployeeRowMapper(),eno);
		return bo;
	}
	
	public static class EmployeeRowMapper implements RowMapper<EmployeeBO>{

		public EmployeeBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmployeeBO bo=new EmployeeBO();
			bo.setEmpno(rs.getInt(1));
			bo.setEname(rs.getString(2));
			bo.setJob(rs.getString(3));
			bo.setSal(rs.getInt(4));
			
            return bo;
		}
	}
	
	@Override
	public List<EmployeeBO> getEmpsByDesg(String desg) {
		List<EmployeeBO> listBo=null;
		
		listBo=jt.query(GET_EMPS_BY_DESG,new EmployeeExtractor(), desg);
		return listBo;
	}
	
	
	public static class EmployeeExtractor implements ResultSetExtractor<List<EmployeeBO>>{

		@Override
		public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<EmployeeBO> listBo=null;
			EmployeeBO bo=null;
			listBo=new ArrayList<EmployeeBO>();
			if(rs!=null) {
			    while(rs.next()) {
			    	bo=new EmployeeBO();
			    	bo.setEmpno(rs.getInt(1));
					bo.setEname(rs.getString(2));
					bo.setJob(rs.getString(3));
					bo.setSal(rs.getInt(4));
					
			    	listBo.add(bo);
			    }
			}
			return listBo;
		}
    }
	
	

	@Override
	public List<EmployeeBO> getEmpsBySalRange(int startSal, int endSal) {
		List<EmployeeBO> listBos=null;
		listBos=new ArrayList<EmployeeBO>();
		jt.query(GET_EMPS_BY_SALRANGE,new EmployeeCallbackHandler(listBos),startSal,endSal);
		return listBos;
	}
	
	public static class EmployeeCallbackHandler implements RowCallbackHandler{
	
		private List<EmployeeBO> listBos;

		public EmployeeCallbackHandler(List<EmployeeBO> listBos) {
			this.listBos = listBos;
		}

		@Override
		public void processRow(ResultSet rs) throws SQLException {
	    	 System.out.println("EmployeeDAOImpl.EmployeeCallbackHandler.processRow()");
		     EmployeeBO bo=new EmployeeBO();
		     bo.setEmpno(rs.getInt(1));
			 bo.setEname(rs.getString(2));
		     bo.setJob(rs.getString(3));
		     bo.setSal(rs.getInt(4));
			
		     listBos.add(bo);
		}
	}
	
	@Override
	public List<EmployeeBO> getEmps() {
		List<EmployeeBO> listBO=new ArrayList<EmployeeBO>();;
		
		jt.query(GET_EMPS,rs->{
			while(rs.next()) {
				EmployeeBO bo=new EmployeeBO();
				bo.setEmpno(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSal(rs.getInt(4));	
				bo.setDeptno(rs.getInt(5));	
				listBO.add(bo);
			}
			return listBO;
		});
		return listBO;
	}
}
