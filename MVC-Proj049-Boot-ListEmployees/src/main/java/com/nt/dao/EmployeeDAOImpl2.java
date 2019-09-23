package com.nt.dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

//@Repository("dao")
public class EmployeeDAOImpl2 implements EmployeeDAO {
	private static final String GET_EMP_BY_ID="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private static final String GET_EMPS_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB=?";
	private static final String GET_EMPS_BY_SALRANGE="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE SAL>=? and SAL<=?";
	
    @Autowired
    private JdbcTemplate jt;

	public EmployeeBO getEmpById(int eno) {
		EmployeeBO bo1=null;
		
		bo1=jt.queryForObject(GET_EMP_BY_ID,
				 (rs,rowNum)-> {
						EmployeeBO bo=new EmployeeBO();
						bo.setEmpno(rs.getInt(1));
						bo.setEname(rs.getString(2));
						bo.setJob(rs.getString(3));
						bo.setSal(rs.getInt(4));
			            return bo;
		        },
				eno);
		return bo1;
	}

	@Override
	public List<EmployeeBO> getEmpsByDesg(String desg) {
		List<EmployeeBO> listBo1=null;
		listBo1= jt.query(GET_EMPS_BY_DESG,rs->{
			List<EmployeeBO> listBo=new ArrayList<EmployeeBO>();
			EmployeeBO bo=null;
			if(rs!=null) {
			  while(rs.next()) {
				  bo=new EmployeeBO();
				  bo.setEmpno(rs.getInt(1));
				  bo.setEname(rs.getString(2));
				  bo.setJob(rs.getString(3));
				  bo.setSal(rs.getInt(4));
				  listBo.add(bo);
			  }
			}
			return listBo;
		}, desg);
		
		return listBo1;
	}

	@Override
	public List<EmployeeBO> getEmpsBySalRange(int startSal, int endSal) {
		List<EmployeeBO> listBos=new ArrayList<EmployeeBO>();
        
		jt.query(GET_EMPS_BY_SALRANGE,
				rs->{
					System.out.println("EmployeeDAOImpl2.getEmpsBySalRange()");
					EmployeeBO bo=new EmployeeBO();
					bo.setEmpno(rs.getInt(1));
					bo.setEname(rs.getString(2));
					bo.setJob(rs.getString(3));
					bo.setSal(rs.getInt(4));
					listBos.add(bo);
				},
				startSal,endSal);
	    return listBos;
	}

	@Override
	public List<EmployeeBO> getEmps() {
		// TODO Auto-generated method stub
		return null;
	}
}
