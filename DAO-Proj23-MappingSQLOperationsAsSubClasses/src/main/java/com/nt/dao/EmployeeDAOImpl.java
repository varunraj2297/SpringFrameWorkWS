package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("dao")
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String GET_EMPS_BY_DESG="SELECT ENO,ENAME,JOB,SAL FROM EMPLOYEE WHERE JOB=?";
	private static final String GET_EMP_BY_ENO="SELECT ENO,ENAME,JOB,SAL FROM EMPLOYEE WHERE ENO=?";
	private static final String INSERT_QUERY="INSERT INTO EMPLOYEE(ENO,ENAME,JOB,SAL) VALUES(EID_SEQ11.NEXTVAL,?,?,?)";
	
	private Selector1 s1;
	private Selector2 s2;
	private Selector3 s3;
	
    @Autowired
	public EmployeeDAOImpl(DataSource ds) {
	     s1=new Selector1(ds,GET_EMPS_BY_DESG);
	     s2=new Selector2(ds,GET_EMP_BY_ENO);
	     s3=new Selector3(ds,INSERT_QUERY);
	}

	@Override
	public List<EmployeeBO> getEmpsByDesg(String desg) {
		List<EmployeeBO> listBos=null;
		listBos=s1.execute(desg);
		return listBos;
	}
	
	@Override
	public EmployeeBO getEmpByEno(int eno) {
		EmployeeBO bo=null;
		bo=s2.findObject(eno);
		
		return bo;
	}
	@Override
	public int insert(EmployeeBO bo) {
		int count=0;
		count=s3.update(bo.getEname(),bo.getJob(),bo.getSal());
		return count;
	}

	
	private static class Selector1 extends MappingSqlQuery<EmployeeBO>{
   
		public Selector1(DataSource ds, String sql) {
			super(ds, sql);
			super.declareParameter(new SqlParameter(Types.VARCHAR));
			super.compile();
		}

		@Override
		protected EmployeeBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("EmployeeDAOImpl.Selector1.mapRow(-,-)");
			EmployeeBO bo=new EmployeeBO();
			bo.setEmpNo(rs.getInt(1));
			bo.setEname(rs.getString(2));
			bo.setJob(rs.getString(3));
			bo.setSal(rs.getInt(4));
			return bo;
		}
		
	}
	
	private static class Selector2 extends MappingSqlQuery<EmployeeBO>{
		   
		public Selector2(DataSource ds, String sql) {
			super(ds, sql);
			super.declareParameter(new SqlParameter(Types.INTEGER));
			super.compile();
		}

		@Override
		protected EmployeeBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("EmployeeDAOImpl.Selector2.mapRow(-,-)");
			EmployeeBO bo=new EmployeeBO();
			bo.setEmpNo(rs.getInt(1));
			bo.setEname(rs.getString(2));
			bo.setJob(rs.getString(3));
			bo.setSal(rs.getInt(4));
			return bo;
		}
	}

	private static class Selector3 extends SqlUpdate{
		   
		public Selector3(DataSource ds, String sql) {
			super(ds, sql);
			super.declareParameter(new SqlParameter(Types.VARCHAR));
			super.declareParameter(new SqlParameter(Types.VARCHAR));
			super.declareParameter(new SqlParameter(Types.INTEGER));
			super.compile();
		}
	}
}
