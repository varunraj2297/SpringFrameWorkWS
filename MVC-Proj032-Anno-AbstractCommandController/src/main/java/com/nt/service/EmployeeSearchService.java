package com.nt.service;

import java.util.List;

import com.nt.command.SearchCommand;
import com.nt.dto.EmployeeDTO;
import com.nt.dto.ResultEmployeeDTO;

public interface EmployeeSearchService {
   public List<ResultEmployeeDTO> processEmps(EmployeeDTO dto);
}
