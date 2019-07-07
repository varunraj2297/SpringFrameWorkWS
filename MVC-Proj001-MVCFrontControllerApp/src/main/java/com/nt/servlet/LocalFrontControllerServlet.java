package com.nt.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.handler.CountryHandlerImpl;
import com.nt.handler.Handler;
import com.nt.handler.LanguageHandlerImpl;

public class LocalFrontControllerServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path=null,lvn=null,target=null;
		Handler handler=null;
		RequestDispatcher rd=null;
		
		res.setContentType("text/html");
		path=req.getServletPath();
		System.out.println(path);
		if(path.equalsIgnoreCase("/lang.do")) {
			handler=new LanguageHandlerImpl();
			lvn=handler.execute(req, res);
		}
		else if(path.equalsIgnoreCase("/country.do")) {
			handler=new CountryHandlerImpl();
			lvn=handler.execute(req, res);
		}
		else {
			throw new IllegalArgumentException();
		}
		if(lvn.equalsIgnoreCase("lang")) {
			target="/show_languages.jsp";
		}
		else if(lvn.equalsIgnoreCase("country")) {
			target="/show_countries.jsp";
		}
		
		rd=req.getRequestDispatcher(target);
		rd.forward(req, res);
		
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

	
}
