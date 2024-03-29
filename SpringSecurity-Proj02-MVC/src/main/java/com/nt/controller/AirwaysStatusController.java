package com.nt.controller;

import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AirwaysStatusController {
   
	@RequestMapping("/status.htm")
	public String showStatus(Map<String,Object> map,@RequestParam("aid") String aid) {
		String status=null;
		
		status=aid+" aeroplane is delayed for "+new Random().nextInt(10)+" hours";
		map.put("status", status);
		return "show_status";
	}
}
