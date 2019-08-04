package com.nt.handler;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class WelcomeController1 extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Calendar calendar=null;
		int hours=0;
		String msg=null;
		
		calendar=Calendar.getInstance();
		hours=calendar.get(Calendar.HOUR_OF_DAY);
		
		if(hours<12)
			msg="Good Morning";
		else if(hours<16)
			msg="Good Afternoon";
		else if(hours<20)
			msg="Good Evening";
		else
			msg="Good Night";
		
		return new ModelAndView("result1","wishMsg",msg);
	}

}
