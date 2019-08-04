package com.nt.interceptor;

import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class TimeOutCheckInterceptor implements HandlerInterceptor {
   
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Calendar calendar=null;
		int hour=0;
		RequestDispatcher rd=null;
		
		calendar=Calendar.getInstance();
		hour=calendar.get(Calendar.HOUR_OF_DAY);
		
		if(hour<13 || hour>=16) {
			rd=request.getRequestDispatcher("/timeout.jsp");
			rd.forward(request, response);
			return false;
		}
		return true;	
	}
}
