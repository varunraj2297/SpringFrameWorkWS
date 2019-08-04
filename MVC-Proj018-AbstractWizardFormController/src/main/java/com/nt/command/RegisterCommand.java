package com.nt.command;

import java.util.Date;

import lombok.Data;

@Data
public class RegisterCommand {
	private String name;
	private String addrs = "Hyd";
	private String gender = "FEMALE";
	private Date dob;
	private String desg;
	private String qlfy;
	private float salary;
	private String expSalary;
	private String[] hobbies;
	private byte expAge;

	public RegisterCommand() {
		System.out.println("RegisterCommand.RegisterCommand()");
	}

}