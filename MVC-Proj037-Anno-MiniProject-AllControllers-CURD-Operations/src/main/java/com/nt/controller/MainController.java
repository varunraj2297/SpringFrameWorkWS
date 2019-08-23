package com.nt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nt.command.NobelPrizeCommand;
import com.nt.dto.NobelPrizeDTO;
import com.nt.service.NobelPrizeService;

@Controller
@SessionAttributes(value="cmd" ,types=NobelPrizeCommand.class)
public class MainController{
    
	@Autowired
	private NobelPrizeService service;
	
	
	@RequestMapping("/home.htm")
	public String showHome(Map<String,Object> map) {
		NobelPrizeCommand command=null;
		
		command=new NobelPrizeCommand();
		map.put("cmd", command);
		return "welcome";
	}
	
	@RequestMapping(value="/add.htm",method=RequestMethod.GET)
	public String showFormPage(@ModelAttribute("cmd") NobelPrizeCommand cmd) {
		return "register";
	}
	
	@RequestMapping(value="/add.htm",method=RequestMethod.POST)
	public String insert(@ModelAttribute("cmd") NobelPrizeCommand cmd,Map<String, Object> map){
	
		NobelPrizeDTO dto=null;
		String resultMsg=null;
		List<NobelPrizeDTO> listDTO=null;
		
		
		
		dto=new NobelPrizeDTO();
		BeanUtils.copyProperties(cmd, dto);
		resultMsg=service.addNobelLaureate(dto);
		listDTO=service.fetchAllNobelLaureates();
		
		map.put("resultMsg", resultMsg);
		map.put("listDTO", listDTO);
		
		return "report";
	}
	
	
	@RequestMapping("/report.htm")
	public String showReport(Map<String, Object> map) {
		List<NobelPrizeDTO> listDTO=null;
		
		listDTO=service.fetchAllNobelLaureates();
		
		map.put("listDTO", listDTO);
		return "report";
	}
	
	@RequestMapping(value="/edit.htm",method=RequestMethod.GET)
	public String showEditForm(HttpServletRequest request,@ModelAttribute("cmd") NobelPrizeCommand cmd)  {
		int id=0;
		NobelPrizeDTO dto=null;
		
		id=Integer.parseInt(request.getParameter("id"));
		dto=service.fetchNobelLaureateById(id);
		BeanUtils.copyProperties(dto,cmd);
		return "edit";
	}
	
	@RequestMapping(value="/edit.htm",method=RequestMethod.POST)
	public String modify(Map<String,Object> map,@ModelAttribute("cmd") NobelPrizeCommand cmd){
		
		NobelPrizeDTO dto=null;
		String resultMsg=null;
		List<NobelPrizeDTO> listDTO=null;
		
	    dto=new NobelPrizeDTO();
	    System.out.println(cmd);
	    BeanUtils.copyProperties(cmd,dto);
	    System.out.println(dto);
	    resultMsg=service.modifyNobelLaureateDetails(dto);
		listDTO=service.fetchAllNobelLaureates();
		
		map.put("listDTO",listDTO);
		map.put("resultMsg",resultMsg);
	   
		return "report";
	}
	
	@RequestMapping(value="/delete.htm")
	public String remove(Map<String,Object> map,HttpServletRequest request) {
		int id=0;
		String resultMsg=null;
		List<NobelPrizeDTO> listDTO=null;
	
		id=Integer.parseInt(request.getParameter("id"));
		resultMsg=service.removeNobelLaureateDetailsById(id);
		listDTO=service.fetchAllNobelLaureates();
		
		
		map.put("listDTO",listDTO);
		map.put("resultMsg",resultMsg);
	    
	    return "report";
	}
	
}
