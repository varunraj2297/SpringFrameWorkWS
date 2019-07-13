package com.nt.command;

import lombok.Data;

@Data
public class SearchCommand {
    private int eno;
    private String ename;
    private String desg;
    private int salary;
    
	public SearchCommand() {
		System.out.println("SearchCommand-0-param-constructor");
	}
}
