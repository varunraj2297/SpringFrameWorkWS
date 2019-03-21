package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.nt.bo.EmployeeBO;

public class EmployeeDaoImpl implements EmployeeDao {
	private DataSource ds=null;
	private static final String GET_EMP_DETAILS="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?)";
	public EmployeeDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<EmployeeBO> getEmpDetails(String desg1, String desg2, String desg3) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List listBO=null;
		try {
		 	con=ds.getConnection();
		 	if(con!=null)
		 	  ps=con.prepareStatement(GET_EMP_DETAILS);
		 	
		 	//set the query params
		 	if(con!=null) {
		 	ps.setString(1,desg1);
		 	ps.setString(2,desg2);
		 	ps.setString(3,desg3);
		 	rs=ps.executeQuery();
		 	}
		 	listBO = new ArrayList();
		 	while(rs.next()) {
		 		EmployeeBO bo=new EmployeeBO();
		 		bo.setEmpNo(rs.getInt(1));
		 		bo.setEmpName(rs.getString(2));
		 		bo.setJob(rs.getString(3));
		 		bo.setSalary(rs.getInt(4));
		 		//add bo to listBO
		 		listBO.add(bo);
		 	}//while
		}//try
		catch (SQLException se) {
			 throw se;
		}
		
		finally {
			 // close all jdbc objects
			try {
				if(rs!=null)
				rs.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(ps!=null)
				ps.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(con!=null)
				con.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}//finally
		return listBO;
	}//getEmpDetails

}//class