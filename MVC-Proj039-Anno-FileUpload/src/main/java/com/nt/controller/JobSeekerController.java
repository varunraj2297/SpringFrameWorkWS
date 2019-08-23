package com.nt.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.command.JobSeekerCommand;

@Controller
public class JobSeekerController {
   
	@RequestMapping(name="/register.htm",method=RequestMethod.GET)
	public String showForm(@ModelAttribute("cmd") JobSeekerCommand command ) {
		return "jobSeeker_register";
	}
	
	@RequestMapping(name="/register.htm",method=RequestMethod.POST)
	public String process(@ModelAttribute("cmd") JobSeekerCommand command,Map<String, Object> map,HttpServletRequest req) {
		InputStream is1=null,is2=null;
		File uploadLoc=null;
		String file1=null,file2=null;
		ServletContext sc=null;
        OutputStream os1=null,os2=null;		
		
        System.out.println(command);
		try {
		   is1=command.getResume().getInputStream();
		   is2=command.getPhoto().getInputStream();
		   
		   sc=req.getServletContext();
		   uploadLoc=new File(sc.getInitParameter("uploadLoc"));
		   if(!uploadLoc.exists()) 
			   uploadLoc.mkdir();
		   
		   file1=command.getResume().getOriginalFilename();
		   file2=command.getPhoto().getOriginalFilename();
		   
		   os1=new FileOutputStream(uploadLoc.getAbsolutePath()+"/"+file1);
		   os2=new FileOutputStream(uploadLoc.getAbsolutePath()+"/"+file2);
		   
		   IOUtils.copy(is1, os1);
		   IOUtils.copy(is2, os2);
		   
		   map.put("file1", file1);
		   map.put("file2", file2);
		   
		}
		catch (Exception e) {
           e.printStackTrace();
		}
		return "upload_success";
	}
}
