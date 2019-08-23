package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TilesController {
    
	@RequestMapping("/welcome.htm")
	public String showHome() {
		return "page1Def";
	}
	
	@RequestMapping("/entertainment.htm")
	public String showEntertainment() {
		return "page2Def";
	}
	
	@RequestMapping("/horoscope.htm")
	public String showHoroscope() {
		return "page3Def";
	}
	
	@RequestMapping("/weather.htm")
	public String showWeather() {
		return "page4Def";
	}
	
	@RequestMapping("/stock.htm")
	public String showStock() {
		return "page5Def";
	}
	
	
}
