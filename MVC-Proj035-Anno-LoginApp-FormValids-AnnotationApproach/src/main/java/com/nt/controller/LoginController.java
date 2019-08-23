package com.nt.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nt.command.LoginCommand;
import com.nt.dto.LoginDTO;
import com.nt.service.LoginService;

@Controller
//@SessionAttributes(value="loginCmd",types=LoginCommand.class)
public class LoginController {
    
	@Autowired
	private LoginService service;
	
	/*@Autowired
	private LoginValidator validator;*/
    
	@RequestMapping(name="/home.htm",method=RequestMethod.GET)
    public String showForm(@ModelAttribute("loginCmd") LoginCommand cmd) {
    	return "form";
    }
	
	@RequestMapping(name="/home.htm",method=RequestMethod.POST)
	public String process(Map<String,Object> map,@Valid @ModelAttribute("loginCmd") LoginCommand cmd,BindingResult errors) {
        LoginDTO dto=null;
        
       
		/* if(validator.supports(LoginCommand.class)) {
			validator.validate(cmd, errors);
			if(errors.hasErrors()) 
			    return "form"; 
		}
		
		if(cmd.getUsername().equalsIgnoreCase("raja")) {
		   errors.rejectValue("username","user.blocked");
		   return "form";
		}*/
        if(errors.hasErrors())
        	return "form";
        dto=new LoginDTO();
        BeanUtils.copyProperties(cmd, dto);
        map.put("result", service.verify(dto));
        return "form";
	}
	
	@ModelAttribute("hobbiesList")
	public List<String> populateHobbies(){
		List<String> hobbiesList=null;
		
		hobbiesList=new ArrayList<String>();
		hobbiesList.add("sleeping");
		hobbiesList.add("coding");
		hobbiesList.add("eating");
		
		return hobbiesList;
	}
	
	@ModelAttribute("countriesList")
	public List<String> populateCountries(){
		List<String> countriesList=null;
		
		countriesList=new ArrayList<String>();
		countriesList.add("India");
		countriesList.add("Australia");
		countriesList.add("America");
		
		return countriesList;
	}
	
	@InitBinder
	public void myBinder(ServletRequestDataBinder binder) {
		SimpleDateFormat sdf=null;
		
		sdf=new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class,new CustomDateEditor(sdf, true));
		
	}
	
}
