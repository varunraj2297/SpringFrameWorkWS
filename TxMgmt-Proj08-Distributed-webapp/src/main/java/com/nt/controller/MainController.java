package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;

public class MainController extends HttpServlet{
	
	private ApplicationContext ctx;
	private BankService proxy;
	
	@Override
	public void init() throws ServletException {
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		proxy=ctx.getBean("bankService",BankService.class);
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int srcNo=0,destNo=0;
		float amt=0;
		String status=null;
		RequestDispatcher rd=null;
		
		res.setContentType("text/html");
		srcNo=Integer.parseInt(req.getParameter("srcNo"));
		destNo=Integer.parseInt(req.getParameter("destNo"));
		amt=Float.parseFloat(req.getParameter("amt"));
		
		try {
			status=proxy.transferMoney(srcNo, destNo, amt);
			req.setAttribute("status",status);
			rd=req.getRequestDispatcher("/result.jsp");
			rd.forward(req, res);
		}
		catch (Exception e) {
			req.setAttribute("status",e.getMessage());
			rd=req.getRequestDispatcher("/error.jsp");
			rd.forward(req, res);
		}
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	     doGet(req, res);	
	}

	@Override
	public void destroy() {
	    proxy=null;
	    ((AbstractApplicationContext) ctx).close();
	}
}
