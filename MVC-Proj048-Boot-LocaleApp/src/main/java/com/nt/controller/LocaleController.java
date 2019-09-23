package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.LocaleService;

@Controller
public class LocaleController {
   
	@Autowired
	private LocaleService service;
	
	
	
	@RequestMapping(name="/home.htm")
	public String showHome() {
		return "welcome";
	}
	
	@RequestMapping("/languages.htm")
	public String showLanguages(Map<String,Object> map) {
		List<String> languages=null;
		languages=service.getAllLanguages();
		map.put("locales", languages);
		map.put("operation","Languages");
		return "result";
	}
	
	@RequestMapping("/countries.htm")
	public String showCountries(Map<String,Object> map) {
		List<String> countries=null;
		countries=service.getAllCountries();
		map.put("locales", countries);
		map.put("operation","Countries");
		return "result";
	}
}
