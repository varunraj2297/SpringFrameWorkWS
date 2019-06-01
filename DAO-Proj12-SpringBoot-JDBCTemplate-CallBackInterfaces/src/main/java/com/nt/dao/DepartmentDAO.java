package com.nt.dao;

import java.util.List;
import java.util.Map;

public interface DepartmentDAO {
    public int getDeptCount();
    public Map<String,Object> getDeptByNo(int no);
    public String getDeptLocByNo(int no);
    public List<Map<String,Object>> getAllDepts();
    public List<Map<String,Object>> getDeptsWithTwoLocs(String loc1,String loc2);
    public int insertDept(String dname,String loc);
    public int updateDept(String newLoc,String oldLoc);
    public int deleteDept(int deptno);
}
