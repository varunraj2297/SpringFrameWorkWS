package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface EmpService {
   public EmployeeDTO fetchEmpById(int eno);  
   public List<EmployeeDTO> fetchEmpsByDesg(String desg);
   public List<EmployeeDTO> fetchEmpsBySalRange(int startSal,int endSal);
}