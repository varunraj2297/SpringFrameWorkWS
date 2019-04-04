package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.nt.bo.EmployeeBO;
import com.nt.bo.StudentBO;


public class DAO {
	private static final String INSERT_STUDENT="INSERT INTO REGISTER_STUDENT VALUES(?,?,?,?,?,?)";
	private static final String INSERT_EMPLOYEE="INSERT INTO REGISTER_EMPLOYEE VALUES(?,?,?,?,?,?)";
	
	private DataSource ds;
	int count=0;
	
	public DAO(DataSource ds) {
		System.out.println("StudentDAO:: 1 param con");
		this.ds = ds;
	}
	
	public int insertStudent(StudentBO bo) {
		try(Connection con=ds.getConnection()) {
			try(PreparedStatement ps=con.prepareStatement(INSERT_STUDENT)){
			ps.setString(1,bo.getName());
			ps.setString(2,bo.getAddrs());
			ps.setString(3,bo.getEmail());
			ps.setLong(4,bo.getMobileNo());
			ps.setString(5,bo.getCourse());
			ps.setDate(6,bo.getDoj());
			
			count=ps.executeUpdate();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public int insertEmployee(EmployeeBO bo) {
		
		try(Connection con=ds.getConnection()) {
			try(PreparedStatement ps=con.prepareStatement(INSERT_EMPLOYEE)){
			ps.setString(1,bo.getName());
			ps.setString(2,bo.getAddrs());
			ps.setString(3,bo.getEmail());
			ps.setLong(4,bo.getMobileNo());
			ps.setString(5,bo.getDesg());
			ps.setDate(6,bo.getDoj());
			
			count=ps.executeUpdate();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
}