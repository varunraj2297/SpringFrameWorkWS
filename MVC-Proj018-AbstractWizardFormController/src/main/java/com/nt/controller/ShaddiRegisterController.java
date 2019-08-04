package com.nt.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

import com.nt.command.RegisterCommand;

public class ShaddiRegisterController extends AbstractWizardFormController{
	
	@Override
	public Map referenceData(HttpServletRequest request, int page) throws Exception {
		System.out.println("ShaddiRegisterController.referenceData()"+page);
		List<String> gendersList=null;
		Map<String,List<String>> map=null;
		List<String> hobbiesList=null;
		
		gendersList=new ArrayList<>();
		gendersList.add("MALE");
		gendersList.add("FEMALE");
		
		hobbiesList=new ArrayList<>();
		hobbiesList.add("eating");
		hobbiesList.add("coding");
		hobbiesList.add("sleeping");
		
		map=new HashMap<>();
		map.put("gendersList", gendersList);
		map.put("hobbiesList", hobbiesList);
		
		return map;
		
	}
	
	@Override
	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		System.out.println("ShaddiRegisterController.initBinder()");
		SimpleDateFormat sdf=null;
		sdf=new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class,new CustomDateEditor(sdf, true));
	}
	
	
	@Override
	public ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		System.out.println("ShaddiRegisterController.processFinish()");
		RegisterCommand cmd=null;
		
		cmd=(RegisterCommand)command;
		return new ModelAndView("result","regCmd",cmd);
	}
	
	@Override
	public ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		System.out.println("ShaddiRegisterController.processCancel()");
        return new ModelAndView("welcome");
	}
    
}
