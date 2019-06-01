package com.nt.service;

import java.util.List;
import java.util.Map;

public interface DeptService {
   public int findDeptCount();
   public Map<String,Object> findDeptByNo(int no);
   public String findDeptLocByNo(int no);
   public List<Map<String,Object>> findAllDepts();
   public List<Map<String,Object>> findDeptsWithTwoLocs(String loc1,String loc2);
   public String registerDept(String dname,String loc);
   public String modifyDept(String newLoc,String oldLoc);
   public String removeDept(int deptno);
}
