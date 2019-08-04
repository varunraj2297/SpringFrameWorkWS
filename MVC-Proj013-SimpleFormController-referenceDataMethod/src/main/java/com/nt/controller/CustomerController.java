package com.nt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class CustomerController extends SimpleFormController{
	
	@Override
	public Map referenceData(HttpServletRequest request) throws Exception {
		System.out.println("CustomerController.referenceData()");
		List<String> gendersList=null;
		List<String> hobbiesList=null;
		List<String> countriesList=null;
		List<String> productsList=null;
		Map<String, List<String>> map=null;
		
		gendersList=new ArrayList<String>();
		gendersList.add("MALE");  gendersList.add("FEMALE");
		
		countriesList=new ArrayList<String>();
		countriesList.add("INDIA"); countriesList.add("AUSTRALIA");
		countriesList.add("AMERICA");countriesList.add("CHINA");
		countriesList.add("ENGLAND");
		
		hobbiesList=new ArrayList<String>();
		hobbiesList.add("reading"); hobbiesList.add("playing chess");
		hobbiesList.add("riding");
		
		productsList=new ArrayList<String>();
		productsList.add("TV"); productsList.add("DVD Player");
		productsList.add("Mobile Phone"); productsList.add("AC");
		productsList.add("Refridgerator");
		
		map=new HashMap<String, List<String>>();
		map.put("gendersList", gendersList);
		map.put("countriesList", countriesList);
		map.put("hobbiesList", hobbiesList);
		map.put("productsList", productsList);
		
		
		return map;
	}
	
	@Override
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		System.out.println("CustomerController.onSubmit()");
        return new ModelAndView(getSuccessView(),"cmdData",command);
	}
}
