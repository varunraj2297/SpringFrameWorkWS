package com.nt.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nt.service.WishMessageService;

@Controller("welcomeController")
public class WelcomeController {
	@Autowired
	private WishMessageService service;

	/*@RequestMapping("/wish.htm")
	public ModelAndView process() {
		String msg=null;
		
		msg=service.getWishMessage();
		return new ModelAndView("result","wishMsg",msg);
	}*/

	/*@RequestMapping("/wish.htm")
	public Model process() {
		String msg=null;
		Model model=null;
		
		model=new BindingAwareModelMap();
		msg=service.getWishMessage();
		model.addAttribute("wishMsg",msg);
		return model;
	}*/

	/*@RequestMapping("/wish.htm")
	public ModelMap process() {
		String msg=null;
		ModelMap model=null;
		
		model=new BindingAwareModelMap();
		msg=service.getWishMessage();
		model.addAttribute("wishMsg",msg);
		return model;
	}*/

	/*@RequestMapping("/wish.htm")
	public Map<String, Object> process() {
		String msg=null;
		Map<String, Object> map=null;
		
		map=new HashMap<>();
		msg=service.getWishMessage();
		map.put("wishMsg",msg);
		return map;
	}*/

	/*@RequestMapping("/wish.htm")
	public void process(Model model) {
		String msg=null;
		
		System.out.println(model.getClass().getName());
		msg=service.getWishMessage();
		model.addAttribute("wishMsg", msg);
	}*/

	/*@RequestMapping("/wish.htm")
	public void process(ModelMap map) {
		String msg=null;
		
		System.out.println(map.getClass().getName());
		msg=service.getWishMessage();
		map.addAttribute("wishMsg", msg);
	}*/

	/*@RequestMapping("/wish.htm")
	public void process(Map<String, Object> map) {
		String msg = null;
	
		System.out.println(map.getClass().getName());
		msg = service.getWishMessage();
		map.put("wishMsg", msg);
	}*/
	
	@RequestMapping("/home.htm")
	public String showHome() {
		return "welcome";
	}
	
	@RequestMapping("/wish.htm")
	public String process(Map<String, Object> map) {
		String msg = null;
	
		System.out.println(map.getClass().getName());
		msg = service.getWishMessage();
		map.put("wishMsg", msg);
		return "result";
	}

}
