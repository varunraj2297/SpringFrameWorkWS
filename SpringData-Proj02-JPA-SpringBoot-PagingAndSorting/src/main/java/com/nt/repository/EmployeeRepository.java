package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.nt.entity.EmployeeEntity;

public interface EmployeeRepository extends PagingAndSortingRepository<EmployeeEntity,Integer> {

}