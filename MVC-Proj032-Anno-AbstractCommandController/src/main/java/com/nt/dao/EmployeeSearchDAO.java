package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBO;
import com.nt.bo.ResultEmployeeBO;

public interface EmployeeSearchDAO {
	public List<ResultEmployeeBO> findEmps(EmployeeBO bo);
}
