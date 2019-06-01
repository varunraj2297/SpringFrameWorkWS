package com.nt.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.nt.bo.StudentBO;

@Component
public class StudentDAOImpl implements StudentDAO {
	private static final String INSERT_STUDENT_QUERY="INSERT INTO LAYERED_APP_STUDENT VALUES(SNO_SEQ1.NEXTVAL,?,?,?,?,?)";
	@Autowired
	private DataSource ds;
	

	public StudentDAOImpl() {
		System.out.println("StudentDAOImpl 0-param con");
	}


	public StudentDAOImpl(DataSource ds) {
		this.ds = ds;
	}


	@Override
	public int insert(StudentBO bo) throws Exception {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		String result=null;
		
		con=ds.getConnection();
		ps=con.prepareStatement(INSERT_STUDENT_QUERY);
		ps.setString(1,bo.getSname());
		ps.setString(2,bo.getSadd());
		ps.setInt(3,bo.getTotal());
		ps.setFloat(4,bo.getAvg());
		ps.setString(5,bo.getResult());
			
		count=ps.executeUpdate();
		ps.close();
		con.close();
		return count;
	}

}
