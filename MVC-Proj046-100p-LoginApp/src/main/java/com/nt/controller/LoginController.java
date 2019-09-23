package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.command.LoginCommand;
import com.nt.dto.LoginDTO;
import com.nt.service.LoginService;

@Controller
public class LoginController {
    
	@Autowired
	private LoginService service;
    
	//@RequestMapping(name="/home.htm",method=RequestMethod.GET)
    @GetMapping(name="/home.htm")
	public String showForm(@ModelAttribute("loginCmd") LoginCommand cmd) {
    	return "form";
    }
	
	//@RequestMapping(name="/home.htm",method=RequestMethod.POST)
	@PostMapping(name="/home.htm")
    public String process(@ModelAttribute("loginCmd") LoginCommand cmd,Map<String,Object> map) {
        LoginDTO dto=null;
        
        dto=new LoginDTO();
        BeanUtils.copyProperties(cmd, dto);
        map.put("result", service.verify(dto));
        return "form";
	}
}
