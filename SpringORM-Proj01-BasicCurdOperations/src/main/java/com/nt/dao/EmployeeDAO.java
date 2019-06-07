package com.nt.dao;

import com.nt.entity.EmployeeHLO;

public interface EmployeeDAO{
     public EmployeeHLO getEmpByEno(int eno)  throws Exception;
     public int insertEmp(EmployeeHLO hlo);
     public float getEmpSalById(int eno);
     //public int updateEmpSalById(int eno,float percentage);
     public int updateEmpSalById(int eno,float newSalary);
     public int deleteEmpsBySalRange(float minSal,float maxSal);
}
