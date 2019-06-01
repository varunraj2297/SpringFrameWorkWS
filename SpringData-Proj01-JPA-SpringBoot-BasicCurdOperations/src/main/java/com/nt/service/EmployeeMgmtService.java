package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface EmployeeMgmtService {
    public List<EmployeeDTO> getAllEmployees();
    public EmployeeDTO getEmployeeById(int eno);
    public List<EmployeeDTO> getEmpsByDesg(String desg1,String desg2);
    public long getEmpsCount();
    public long getEmpsSalariesTotal();
    public String registerEmployee(EmployeeDTO dto);
    public String addBonusToEmpsByDesg(float bonus,String desg);
	
}
