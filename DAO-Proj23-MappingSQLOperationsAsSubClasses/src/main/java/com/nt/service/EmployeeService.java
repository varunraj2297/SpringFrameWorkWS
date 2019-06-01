package com.nt.service;


import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface EmployeeService {
	public List<EmployeeDTO> fetchEmpsByDesg(String desg);
	public EmployeeDTO fetchEmpByEno(int eno);
	public String registerEmployee(EmployeeDTO dto);
}