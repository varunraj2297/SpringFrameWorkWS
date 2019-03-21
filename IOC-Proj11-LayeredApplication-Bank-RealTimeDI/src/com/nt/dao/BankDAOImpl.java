package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.nt.bo.BankBO;

public class BankDAOImpl implements BankDAO {
	private static final String INSERT_QUERY="INSERT INTO BANK VALUES(CID_SEQ.NEXTVAL,?,?,?,?)";
	private DataSource ds;
	

	public BankDAOImpl(DataSource ds) {
		this.ds = ds;
	}


	@Override
	public int insert(BankBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
				
		con=ds.getConnection();
		ps=con.prepareStatement(INSERT_QUERY);
		
		ps.setString(1,bo.getCname());
		ps.setString(2,bo.getCadd());
		ps.setFloat(3,bo.getSi());
		ps.setDouble(4,bo.getCi());
		
		count=ps.executeUpdate();
		
		ps.close();
		con.close();
		
		return count;
	}

}
