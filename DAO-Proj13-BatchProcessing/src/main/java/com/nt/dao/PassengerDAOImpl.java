package com.nt.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.PassengerBO;

@Repository("dao")
public class PassengerDAOImpl implements PassengerDAO {
	private static final String INSERT_BATCH="INSERT INTO RAILWAY_TICKET VALUES(PIDS_SEQ.NEXTVAL,?,?,?,?)";
	
    @Autowired
    private JdbcTemplate jt;

	@Override
	public int[] insertBatch(List<PassengerBO> listBOs) {
		int[] result=null;
		result=jt.batchUpdate(INSERT_BATCH,new MyBatchPreparedStatementSetter(listBOs));
	    return result;
	}
	
	public class MyBatchPreparedStatementSetter implements BatchPreparedStatementSetter{

		private List<PassengerBO> listBOs;
		
		
		public MyBatchPreparedStatementSetter(List<PassengerBO> listBOs) {
			this.listBOs = listBOs;
		}

		@Override
		public void setValues(PreparedStatement ps, int i) throws SQLException {
			ps.setString(1,listBOs.get(i).getName());
			ps.setString(2,listBOs.get(i).getSrc());
			ps.setString(3,listBOs.get(i).getDest());
			ps.setInt(4,listBOs.get(i).getPrice());
		}

		@Override
		public int getBatchSize() {
			return listBOs.size();
		}
		
	}

	
}
