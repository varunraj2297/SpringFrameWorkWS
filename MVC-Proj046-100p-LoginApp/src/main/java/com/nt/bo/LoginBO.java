package com.nt.bo;

import lombok.Data;

@Data
public class LoginBO {
	private String username;
	private String password;

	public LoginBO() {
        System.out.println("LoginBO-no-param constructor");
	}
}
