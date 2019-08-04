package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.nt.commad.UserCommand;

public class CURDOperationController extends MultiActionController{

	public ModelAndView insert(HttpServletRequest req,HttpServletResponse res,UserCommand cmd) {
		ModelAndView mav=null;
		
		mav=new ModelAndView();
		mav.setViewName("form");
		mav.addObject("cmdData",cmd);
		mav.addObject("operation","insert");
		return mav;
	}
	
	public ModelAndView update(HttpServletRequest req,HttpServletResponse res,UserCommand cmd) {
		ModelAndView mav=null;
		mav=new ModelAndView();
		mav.setViewName("form");
		mav.addObject("cmdData",cmd);
		mav.addObject("operation","update");
		return mav;
	}
	
	public ModelAndView delete(HttpServletRequest req,HttpServletResponse res,UserCommand cmd) {
		ModelAndView mav=null;
		
		mav=new ModelAndView();
		mav.setViewName("form");
		mav.addObject("cmdData",cmd);
		mav.addObject("operation","delete");
		return mav;
	}
	
	public ModelAndView view(HttpServletRequest req,HttpServletResponse res,UserCommand cmd) {
		ModelAndView mav=null;
		
		mav=new ModelAndView();
		mav.setViewName("form");
		mav.addObject("cmdData",cmd);
		mav.addObject("operation","view");
		return mav;
	}
	
	public ModelAndView invalid(HttpServletRequest req,HttpServletResponse res,UserCommand cmd) {
		ModelAndView mav=null;
		
		mav=new ModelAndView();
		mav.setViewName("form");
		mav.addObject("cmdData",cmd);
		mav.addObject("operation","invalid");
		return mav;
	}
	
}
