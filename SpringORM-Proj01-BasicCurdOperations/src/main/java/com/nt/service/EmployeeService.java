package com.nt.service;

import com.nt.dto.EmployeeDTO;

public interface EmployeeService{
    public EmployeeDTO fetchEmpByEno(int eno)  throws Exception;
    public String registerEmp(EmployeeDTO dto);
    public float findEmpSalById(int eno);
   // public String hikeEmpSalById(int eno,float percentage);
    public String hikeEmpSalById(int eno,float percentage);
    public String ression(float minSal,float maxSal);
}
