package com.nt.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DownloadServiceImpl implements DownloadService{

	@Override
	public List<String> getFilesList(String location) {
		File[] files=null;
		File srcLoc =null;
		List<String> lof=null;
		
		srcLoc=new File(location);
		if(srcLoc.exists()) {
			files=srcLoc.listFiles();
			
			lof=new ArrayList<>();
			for(File f:files) {
				lof.add(f.getName());
			}
		}
		return lof;
	}

}
