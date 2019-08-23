package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.service.DownloadService;

@Controller
public class DownloadController {
	
	@Autowired
	private DownloadService service;

	@RequestMapping("/welcome.htm")
	public String showHome(HttpServletRequest req,Map<String,Object> map) {
		ServletContext sc=null;
		String sourceLoc=null;
        List<String> lof=null;
		
		sc=req.getServletContext();
		sourceLoc=sc.getInitParameter("sourceLoc");
		lof=service.getFilesList(sourceLoc);
		map.put("lof", lof);
		return "home";
	}
	
	@RequestMapping("/download.htm")
    public void downloadData(@RequestParam("fileName") String fileName,HttpServletRequest req,HttpServletResponse res) throws Exception{
		ServletContext sc=null;
		String sourceLoc=null;
		File fileToDownload=null;
		InputStream is=null;
		OutputStream os=null;
		
		
		sc=req.getServletContext();
		sourceLoc=sc.getInitParameter("sourceLoc");
		fileToDownload=new File(sourceLoc+"/"+fileName);

		res.setContentLengthLong(fileToDownload.length());
		res.setContentType(sc.getMimeType(sourceLoc+"/"+fileName));
		res.addHeader("Content-Disposition", "attachment;fileName="+fileName);		
		is=new FileInputStream(fileToDownload);
		os=res.getOutputStream();
		IOUtils.copy(is, os);
		is.close();
		os.close();
	}
}
