package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nt.entity.EmployeeEntity;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {

	@Query("from EmployeeEntity where job in(:job1,:job2)")
	public List<EmployeeEntity> findEmpsByDesgs(@Param("job1")String desg1,@Param("job2")String desg2);
    
	@Query("select sum(sal) from EmployeeEntity")
	public long findEmpsSalariesTotal();
	
	@Query("update EmployeeEntity set sal=sal+:bns where job=:desg")
	@Modifying
	public int rewardBonusToEmpsByDesg(@Param("bns")float bonus,@Param("desg")String desg);

}