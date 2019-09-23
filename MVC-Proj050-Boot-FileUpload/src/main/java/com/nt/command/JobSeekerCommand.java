package com.nt.command;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class JobSeekerCommand {
	private String jsName;
	private String jsDesg;
	private MultipartFile resume;
	private MultipartFile photo;
	
	
	public JobSeekerCommand() {
		System.out.println("JobSeekerCommand.JobSeekerCommand()");
	}

	
}
