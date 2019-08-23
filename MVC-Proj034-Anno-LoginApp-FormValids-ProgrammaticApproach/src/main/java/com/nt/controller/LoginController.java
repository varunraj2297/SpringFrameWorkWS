package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.command.LoginCommand;
import com.nt.dto.LoginDTO;
import com.nt.service.LoginService;
import com.nt.validator.LoginValidator;

@Controller
public class LoginController {
    
	@Autowired
	private LoginService service;
	
	@Autowired
	private LoginValidator validator;
    
	@RequestMapping(name="/home.htm",method=RequestMethod.GET)
    public String showForm(@ModelAttribute("loginCmd") LoginCommand cmd) {
    	return "form";
    }
	
	@RequestMapping(name="/home.htm",method=RequestMethod.POST)
	public String process(Map<String,Object> map,@ModelAttribute("loginCmd") LoginCommand cmd,BindingResult errors) {
        LoginDTO dto=null;
        
       
        if(validator.supports(LoginCommand.class)) {
       		validator.validate(cmd, errors);
       		if(errors.hasErrors()) 
       		    return "form"; 
       	}

        if(cmd.getUsername().equalsIgnoreCase("raja")) {
    	   errors.rejectValue("username","user.blocked");
           return "form";
        }
        
        dto=new LoginDTO();
        BeanUtils.copyProperties(cmd, dto);
        map.put("result", service.verify(dto));
        return "form";
	}
}
