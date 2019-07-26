package com.nt.command;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class NobelPrizeCommand {
	private int nobelId;
    private int year;
    private String laureate;
    private String field;

    public NobelPrizeCommand() {
		System.out.println("NobelPrizeCommand.NobelPrizeCommand()");
	}
    
}
