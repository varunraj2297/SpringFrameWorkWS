package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.nt.bo.BankBO;

public class BankDAOImpl implements BankDAO {
	private DataSource ds;
	private static final String DEBIT="UPDATE BANKACCOUNT SET BALANCE=BALANCE+? WHERE ACNO=?";
	private static final String CREDIT="UPDATE BANKACCOUNT SET BALANCE=BALANCE-? WHERE ACNO=?";
	private static final String GET_ACC_DETAILS="SELECT ACNO,HOLDERNAME,ADDRS,BALANCE FROM BANKACCOUNT WHERE ADDRS=?";

	
	public BankDAOImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public String deposit(int accno, int amount) throws Exception {
		int count=0;
		try(Connection con=ds.getConnection()){
			try(PreparedStatement ps=con.prepareStatement(DEBIT)){
				//set values to query param
				ps.setInt(1,amount);
				ps.setInt(2, accno);
				count=ps.executeUpdate();
			}//try2
			
		}//try1
		catch(SQLException se) {
			throw se;
		}
		catch(Exception e) {
			throw e;
		}
		if(count==0)
			return "Amount Not Deposited";
		else
			return "Amount Deposited";
	}

	@Override
	public String moneyTransfer(int srcAccno, int targetAccno, int amount) throws Exception {
		boolean flag=false;
		String result=null;
		try(Connection con=ds.getConnection()){
			try(PreparedStatement ps1=con.prepareStatement(DEBIT)){
				//set values to query param
				ps1.setInt(1,-amount);
				ps1.setInt(2,srcAccno);
				ps1.addBatch();
				ps1.setInt(1,amount);
				ps1.setInt(2,targetAccno);
				ps1.addBatch();
				
				int count[]=ps1.executeBatch();
				for(int i=0;i<count.length;i++) {
					if(count[i]==0) {
						flag=true;
						break;
					}
				}
				if(flag) {
					con.rollback();
					result="Transaction failed";
				}
				else {
					con.commit();
					result="Transaction Succeeded";
				}
			}
		}
		catch(SQLException se) {
			throw se;
		}
		catch(Exception e) {
			throw e;
		}
		return result;
	}

	@Override
	public String withdraw(int accno, int amount) throws Exception {
		int count=0;
		try(Connection con=ds.getConnection()){
			try(PreparedStatement ps=con.prepareStatement(CREDIT)){
				//set values to query param
				ps.setInt(1,amount);
				ps.setInt(2, accno);
				count=ps.executeUpdate();
			}//try2
			
		}//try1
		catch(SQLException se) {
			throw se;
		}
		catch(Exception e) {
			throw e;
		}
		if(count==0)
			return "Amount Not Withdrawn";
		else
			return "Amount Withdrawn";
	}

	@Override
	public List<BankBO> getAccDetails(String addrs) throws Exception {
		// TODO Auto-generated method stub
		List<BankBO> listBO=null;
		try(Connection con=ds.getConnection()){
			try(PreparedStatement ps=con.prepareStatement(GET_ACC_DETAILS)){
				//set values to query param
				ps.setString(1,addrs);
				try(ResultSet rs=ps.executeQuery()){
					listBO=new ArrayList<BankBO>();
					while(rs.next()){
						BankBO bo=new BankBO();
						bo.setAccno(rs.getInt(1));
						bo.setHolderName(rs.getString(2));
						bo.setAddrs(rs.getString(3));
						bo.setBalance(rs.getInt(4));
						listBO.add(bo);
					}//while
				}//try3	
			}//try2		
		}//try1
		catch(SQLException se) {
			throw se;
		}
		catch(Exception e) {
			throw e;
		}
		return listBO;
	}

}
