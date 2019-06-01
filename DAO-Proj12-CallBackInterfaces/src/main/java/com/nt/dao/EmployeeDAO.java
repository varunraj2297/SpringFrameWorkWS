package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBO;

public interface EmployeeDAO {
    public EmployeeBO getEmpById(int eno);
    public List<EmployeeBO> getEmpsByDesg(String desg);
    public List<EmployeeBO> getEmpsBySalRange(int startSal,int endSal);
}
