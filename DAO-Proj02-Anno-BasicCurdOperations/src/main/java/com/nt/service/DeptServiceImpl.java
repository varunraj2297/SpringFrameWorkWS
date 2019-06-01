package com.nt.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.DepartmentDAO;

@Service("service")
public class DeptServiceImpl implements DeptService{
    
	@Autowired
	private DepartmentDAO dao;
	
	
	public DeptServiceImpl(DepartmentDAO dao) {
		this.dao = dao;
	}


	public int findDeptCount() {
		int count=0;
		count=dao.getDeptCount();
		return count;
	}


	public Map<String, Object> findDeptByNo(int no) {
		Map<String,Object> map=null;
		map=dao.getDeptByNo(no);
		return map;
	}


	public String findDeptLocByNo(int no) {
		String loc=null;
		loc=dao.getDeptLocByNo(no);
		return loc;
	}


	public List<Map<String, Object>> findAllDepts() {
		List<Map<String,Object>> allDepts=null;
		allDepts=dao.getAllDepts();
		return allDepts;
	}


	public List<Map<String, Object>> findDeptsWithTwoLocs(String loc1, String loc2) {
		List<Map<String,Object>> deptsByLocs=null;
		deptsByLocs=dao.getDeptsWithTwoLocs(loc1, loc2);
		return deptsByLocs;
	}


	public String registerDept(String dname, String loc) {
		int count=0;
		count=dao.insertDept(dname, loc);
		if(count==1) 
			return "Object is saved";
		else
			return "Object is not saved";
	}


	public String modifyDept(String newLoc, String oldLoc) {
		int count=0;
		count=dao.updateDept(newLoc, oldLoc);
		if(count==1) 
			return "Object is updated "+count;
		else
			return "Object is not updated";
	}


	public String removeDept(int deptno) {
		int count=0;
		count=dao.deleteDept(deptno);
		if(count==1) 
			return "Object is deleted "+count;
		else
			return "Object is not deleted";
	}
	
	
	
   
}
