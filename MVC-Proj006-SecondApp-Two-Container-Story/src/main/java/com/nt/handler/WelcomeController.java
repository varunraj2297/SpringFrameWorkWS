package com.nt.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.service.WishMessageService;

public class WelcomeController extends AbstractController {
	
	private WishMessageService service;
	
	public WelcomeController(WishMessageService service) {
		System.out.println("WelcomeController-1-param constructor");
		this.service = service;
	}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String msg=null;
		
		msg=service.getWishMessage();
		return new ModelAndView("result","wishMsg",msg);
	}

}
