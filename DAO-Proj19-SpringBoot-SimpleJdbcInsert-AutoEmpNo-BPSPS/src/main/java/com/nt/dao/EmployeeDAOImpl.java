package com.nt.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;
import com.nt.test.JdbcTemplateTest;

@Repository("dao")
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String GET_EMPNO="SELECT EMPNO_SEQ.NEXTVAL FROM DUAL";
	
    @Autowired
    private SimpleJdbcInsert sji;
    private DataSource ds;
    
    public EmployeeDAOImpl(DataSource ds) {
		this.ds=ds;
	}

	private int getAutoEmpNo() {
		int count=0;
		JdbcTemplate template=sji.getJdbcTemplate();
        count=template.queryForObject(GET_EMPNO, Integer.class);
    	return count;
    }

	@Override
	public int insert(EmployeeBO bo) {
		int count=0;
		BeanPropertySqlParameterSource bpsps=null;
		
		bo.setEmpNo(getAutoEmpNo());
		bpsps=new BeanPropertySqlParameterSource(bo);
		
		sji.setTableName("EMP1");
		count=sji.execute(bpsps);
		return count;
	}
}
