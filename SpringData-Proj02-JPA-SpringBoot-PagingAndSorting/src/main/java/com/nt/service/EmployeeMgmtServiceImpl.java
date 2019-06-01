package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.omg.PortableInterceptor.RequestInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dto.EmployeeDTO;
import com.nt.entity.EmployeeEntity;
import com.nt.repository.EmployeeRepository;

@Service("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService{

	@Autowired
	private EmployeeRepository empRepo;

	Pageable pageable=null;
	Page<EmployeeEntity> listEntities=null;
	long pagesCount=0,total=0;
	
	@Override
	public void fetchAllEmps(int pageSize) {
		total=empRepo.count();
	    pagesCount=total/pageSize;
	    
	    if(pagesCount%pageSize!=0)
	    	pagesCount++;
	    
	    for(int pageNo=0;pageNo<pagesCount;pageNo++) {
	    	pageable=PageRequest.of(pageNo,pageSize,Sort.by("desg").descending());
	    	listEntities=empRepo.findAll(pageable);
	    	listEntities.forEach(emp->{
	    		System.out.println(emp);
	    	});
	    	System.out.println(".................................."+(pageNo+1)+" of "+pagesCount);
	    }
	}
 

	
}