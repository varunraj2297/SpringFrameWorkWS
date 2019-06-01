package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.EmployeeService;

@WebServlet(urlPatterns="/controller",loadOnStartup=1)
public class ControllerServlet extends HttpServlet {
	
	
	private EmployeeService service;
	
	@Override
	public void init() throws ServletException {
	    ApplicationContext ctx=null;
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		service=ctx.getBean("service",EmployeeService.class);
		((AbstractApplicationContext) ctx).close();
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    PrintWriter pw=null;
	    String[] desgs=null;
	    List<Map<String,Object>> empsList=null;
	    RequestDispatcher rd=null;
	    
	    res.setContentType("text/html");
	    pw=res.getWriter();
	    desgs=req.getParameterValues("desgs");
	    empsList=service.fetchEmpDetailsByJob(desgs);
	    req.setAttribute("empsList",empsList);
	    rd=req.getRequestDispatcher("/result.jsp");
	    rd.forward(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
