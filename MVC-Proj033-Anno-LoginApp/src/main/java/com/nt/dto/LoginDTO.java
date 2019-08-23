package com.nt.dto;

import lombok.Data;

@Data
public class LoginDTO {
	private String username;
	private String password;

	public LoginDTO() {
        System.out.println("LoginDTO-no-param constructor");
	}
}
