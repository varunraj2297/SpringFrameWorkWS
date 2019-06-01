package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBO;

public interface EmployeeDAO {
    public List<EmployeeBO> getEmpsByDesg(String desg);
    public EmployeeBO getEmpByEno(int eno);
    public int insert(EmployeeBO bo);
}
