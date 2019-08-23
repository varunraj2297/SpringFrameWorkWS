package com.nt.command;

import lombok.Data;

@Data
public class LoginCommand {
	private String username;
	private String password;

	public LoginCommand() {
        System.out.println("LoginCommand-no-param constructor");
	}
}
