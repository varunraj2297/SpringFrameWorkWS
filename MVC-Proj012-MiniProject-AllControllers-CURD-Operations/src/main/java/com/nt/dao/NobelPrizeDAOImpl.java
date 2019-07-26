package com.nt.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import com.nt.bo.NobelPrizeBO;
import com.nt.dao.NobelPrizeDAO;

public class NobelPrizeDAOImpl implements NobelPrizeDAO{
	
	private static final String INSERT_QUERY="INSERT INTO NOBELLAUREATES VALUES(NOBELID_SEQ.NEXTVAL,?,?,?)";
	private static final String GET_NOBEL_LAUREATES = "SELECT NOBELID,YEAR,LAUREATE,FIELD FROM NOBELLAUREATES";
	private static final String GET_NOBEL_LAUREATE_BY_ID = "SELECT NOBELID,YEAR,LAUREATE,FIELD FROM NOBELLAUREATES WHERE NOBELID=?";
	private static final String UPDATE_NOBEL_LAUREATE="UPDATE NOBELLAUREATES SET YEAR=?,LAUREATE=?,FIELD=? WHERE NOBELID=?";
	private static final String DELETE_NOBEL_LAUREATE_BY_ID="DELETE FROM NOBELLAUREATES WHERE NOBELID=?";
	
	private JdbcTemplate jt;
	
	public NobelPrizeDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public int insertNobelLaureate(NobelPrizeBO bo) {
		int count=0;
		count=jt.update(INSERT_QUERY,bo.getYear(),bo.getLaureate(),bo.getField());
	    return count;
	}

	@Override
	public List<NobelPrizeBO> getAllNobelLaureates() {
		BeanPropertyRowMapper<NobelPrizeBO> rowMapper=null;
		List<NobelPrizeBO> listBO=null;
		
		rowMapper=new BeanPropertyRowMapper<NobelPrizeBO>(NobelPrizeBO.class);
		listBO=jt.query(GET_NOBEL_LAUREATES, new RowMapperResultSetExtractor<NobelPrizeBO>(rowMapper));
		return listBO;
	}

	@Override
	public NobelPrizeBO getNobelLaureateById(int id) {
		NobelPrizeBO bo=null;
		bo=jt.queryForObject(GET_NOBEL_LAUREATE_BY_ID,new BeanPropertyRowMapper<NobelPrizeBO>(NobelPrizeBO.class), id);
		return bo;
	}

	@Override
	public int updateNobelLaureateDetails(NobelPrizeBO bo) {
		int count=0;
		count=jt.update(UPDATE_NOBEL_LAUREATE,bo.getYear(),bo.getLaureate(),bo.getField(),bo.getNobelId());
		return count;
	}
	
	@Override
	public int deleteNobelLaureateDetailsById(int id) {
		int count=0;
		count=jt.update(DELETE_NOBEL_LAUREATE_BY_ID,id);
		return count;
	}

}
