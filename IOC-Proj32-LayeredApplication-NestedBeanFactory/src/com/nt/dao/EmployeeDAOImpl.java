package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.nt.bo.EmployeeBO;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String GET_EMP_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?) ORDER BY JOB";
	private DataSource ds;
	
	public EmployeeDAOImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<EmployeeBO> searchEmpByDesg(String desg1, String desg2, String desg3) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		EmployeeBO bo=null;
		List<EmployeeBO> listBO=null;
		try{
			//get pooledConnection obj
			con=ds.getConnection();
			//create preparedStatement object
			ps=con.prepareStatement(GET_EMP_BY_DESG);
			//set values to Query param
			ps.setString(1,desg1);
			ps.setString(2,desg2);
			ps.setString(3,desg3);
			//execute the query
			rs=ps.executeQuery();
			//copy the records into listBO obj
			listBO=new ArrayList();
			while(rs.next()) {
				bo=new EmployeeBO();
				bo.setEno(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setDesg(rs.getString(3));
				bo.setSalary(rs.getInt(4));
				listBO.add(bo);
			}
		}
		catch(SQLException se) {
			throw se;
		}
		finally {
			try {
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(ps!=null)
					ps.close();
			}
			catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch (SQLException se) {
				se.printStackTrace();
			}
		}//finally
		return listBO;
	}//searchEmpByDesg(-,-,-)
}//class
