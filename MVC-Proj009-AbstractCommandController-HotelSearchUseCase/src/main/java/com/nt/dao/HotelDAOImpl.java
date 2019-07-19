package com.nt.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import com.nt.bo.HotelBO;
import com.nt.bo.HotelResultBO;

public class HotelDAOImpl implements HotelDAO{
	
	//private static final String GET_HOTELS="SELECT HOTELID,HNAME,TYPE,RATING,COST,LOCATION FROM HOTEL WHERE HOTELID=? OR HNAME=? OR TYPE=? OR COST=?";
	
	private static String GET_HOTELS;
	private JdbcTemplate jt;
	
	
	public HotelDAOImpl(JdbcTemplate jt) {
		System.out.println("HotelDAOImpl-1-param constructor");
		this.jt = jt;
	}


	@Override
	public List<HotelResultBO> searchHotels(HotelBO bo) {
		BeanPropertyRowMapper<HotelResultBO> rowMapper=null;
		List<HotelResultBO> listRBO=null;
		
		rowMapper=new BeanPropertyRowMapper<HotelResultBO>(HotelResultBO.class);
		if(bo.getHotelid()==0 && bo.getHname().equals("") && bo.getType().equals("") && bo.getCost()==0) {
			GET_HOTELS="SELECT HOTELID,HNAME,TYPE,RATING,COST,LOCATION FROM HOTEL";
			listRBO=(List<HotelResultBO>) jt.query(GET_HOTELS,new RowMapperResultSetExtractor(rowMapper));
		}
		else {
			GET_HOTELS="SELECT HOTELID,HNAME,TYPE,RATING,COST,LOCATION FROM HOTEL WHERE HOTELID=? OR HNAME=? OR TYPE=? OR COST=?";
			listRBO=(List<HotelResultBO>) jt.query(GET_HOTELS,new RowMapperResultSetExtractor(rowMapper), bo.getHotelid(),bo.getHname(),bo.getType(),bo.getCost());
		}
		return listRBO;
	}
   
}
