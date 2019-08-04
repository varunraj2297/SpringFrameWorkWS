package com.nt.command;

import java.util.Date;

import lombok.Data;

@Data
public class StudentCommand {
	private int sid;
	private String sname;
	private Date dob;
	private Date doj;
	
}
