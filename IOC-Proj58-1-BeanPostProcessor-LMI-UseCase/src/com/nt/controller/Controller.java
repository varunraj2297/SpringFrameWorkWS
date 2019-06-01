package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.dto.EmployeeDTO;
import com.nt.dto.StudentDTO;
import com.nt.service.Service;

public class Controller extends HttpServlet {
	ApplicationContext ctx;
	Service service;
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("name");
		String addrs=req.getParameter("addrs");
		String email=req.getParameter("email");
		long mobileNo=Long.parseLong(req.getParameter("mobile"));
		String course=null;
		String desg=null;
		String result=null;
		RequestDispatcher rd=null;
		
		String element=req.getParameter("s");
		if(element.equalsIgnoreCase("stusubmit")) { 
			 	course=req.getParameter("course");
			 	StudentDTO sdto=new StudentDTO();
			 	sdto.setName(name);
				sdto.setAddrs(addrs);
				sdto.setEmail(email);
				sdto.setMobileNo(mobileNo);
				sdto.setCourse(course);
				result=service.registerStudent(sdto);
		}
		else { 
			desg=req.getParameter("desg");
			EmployeeDTO edto=new EmployeeDTO();
		 	edto.setName(name);
			edto.setAddrs(addrs);
			edto.setEmail(email);
			edto.setMobileNo(mobileNo);
			edto.setDesg(desg);
			result=service.registerEmployee(edto);
		}
		req.setAttribute("resultMsg",result);
	
		rd=req.getRequestDispatcher("/result.jsp");
		
		rd.forward(req,res);
		
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

	@Override
	public void destroy() {
		service=null;
		((AbstractApplicationContext) ctx).close();
	}

	@Override
	public void init() throws ServletException {
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		service=ctx.getBean("service",Service.class);
	}

	
}
