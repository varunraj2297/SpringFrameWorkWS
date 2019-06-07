package com.nt.bo;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserListBO implements Serializable{
   private String username;
   private String password;
}
