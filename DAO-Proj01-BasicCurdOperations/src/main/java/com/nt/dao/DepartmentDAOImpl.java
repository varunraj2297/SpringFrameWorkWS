package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;


public class DepartmentDAOImpl implements DepartmentDAO {
    private static final String GET_DEPTS_COUNT="SELECT COUNT(*) FROM DEPT";
    private static final String GET_DEPT_BY_NO="SELECT DEPTNO,DNAME,LOC FROM DEPT WHERE DEPTNO=?";
    private static final String GET_DEPTLOC_BY_NO="SELECT LOC FROM DEPT WHERE DEPTNO=?";
    private static final String GET_ALL_DEPTS="SELECT DEPTNO,DNAME,LOC FROM DEPT";
    private static final String GET_DEPTS_BY_TWO_LOCS="SELECT DEPTNO,DNAME,LOC FROM DEPT WHERE LOC IN(?,?)";
    private static final String INSERT_DEPT="INSERT INTO DEPT(DEPTNO,DNAME,LOC) VALUES(5,?,?)";
    private static final String UPDATE_DEPT="UPDATE DEPT SET LOC=? WHERE LOC=?";
    private static final String DELETE_DEPT="DELETE FROM DEPT WHERE DEPTNO=?";
    
    private JdbcTemplate jt;
	
	
	public DepartmentDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}


	public int getDeptCount() {
        int count=0;
        count=jt.queryForObject(GET_DEPTS_COUNT,Integer.class);
		return count;
	}


	public Map<String, Object> getDeptByNo(int no) {
		Map<String,Object> map=null;
		map=jt.queryForMap(GET_DEPT_BY_NO,no);
		return map;
	}


	public String getDeptLocByNo(int no) {
		String loc=null;
		loc=jt.queryForObject(GET_DEPTLOC_BY_NO,String.class,no);
		return loc;
	}


	public List<Map<String, Object>> getAllDepts() {
		List<Map<String,Object>> allDepts=null;
		allDepts=jt.queryForList(GET_ALL_DEPTS);
		return allDepts;
	}


	public List<Map<String, Object>> getDeptsWithTwoLocs(String loc1, String loc2) {
		List<Map<String,Object>> deptsByLocs=null;
		deptsByLocs=jt.queryForList(GET_DEPTS_BY_TWO_LOCS,loc1,loc2);
		return deptsByLocs;
	}


	public int insertDept(String dname, String loc) {
		int count=0;
		count=jt.update(INSERT_DEPT,dname,loc);
		return count;
	}


	public int updateDept(String newLoc, String oldLoc) {
		int count=0;
		count=jt.update(UPDATE_DEPT,newLoc,oldLoc);
		return count;
	}


	public int deleteDept(int deptno) {
		int count=0;
		count=jt.update(DELETE_DEPT,deptno);
		return count;
	}

}
