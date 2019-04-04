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

import com.nt.service.IPLScoreCompService;

public class IPLScoreCompController extends HttpServlet {

	private ApplicationContext ctx;
	private IPLScoreCompService service;
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String score=null;
		int mid=0;
		RequestDispatcher rd=null;
		//read req paramer (mid)
		mid=Integer.parseInt(req.getParameter("mid"));
		//use Service
		score=service.getExtService(mid);
		//keep score(result) is request scope
		req.setAttribute("result",score);
		//forward request show_result.jsp
		rd=req.getRequestDispatcher("/show_result.jsp");
		rd.forward(req, res);
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
		service=ctx.getBean("service",IPLScoreCompService.class);		
	}
	
}
