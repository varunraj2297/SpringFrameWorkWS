package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.apache.bcel.generic.ReturnaddressType;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.CustomerCommand;
import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerService;

public class CustomerInsertController extends SimpleFormController {

	private CustomerService service = null;

	public CustomerInsertController(CustomerService service) {
		System.out.println("CustomerInsertController-1-param constructor");
		this.service = service;
	}

	@Override
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		CustomerCommand cmd=null;
		CustomerDTO dto=null;
		String msg=null;
		
		System.out.println("CustomerInsertController.onSubmit()");
		cmd=(CustomerCommand)command;
		
		if (cmd.getCaddrs().equalsIgnoreCase("hyderabad")) {
		    errors.rejectValue("caddrs", "custCmd.caddrs.restriction");		
	        return showForm(request, response, errors);
		}
		dto=new CustomerDTO();
		
		BeanUtils.copyProperties(cmd, dto);
		msg=service.register(dto);
		
		return new ModelAndView(getSuccessView(),"msg", msg);	
	}

	@Override
	public ModelAndView handleInvalidSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CustomerInsertController.handleInvalidSubmit()");
		return new ModelAndView("dbl_post");
	}
	
	@Override
	public Object formBackingObject(HttpServletRequest request) throws Exception {
		CustomerCommand command=null;
		
		command=new CustomerCommand();
		
		command.setCname("Bolt");
		command.setCaddrs("Jamaica");
		command.setMobileNo(8585858585L);
		command.setBillAmount((float)Math.random()*1000.0f);
		return command;
	}
}
