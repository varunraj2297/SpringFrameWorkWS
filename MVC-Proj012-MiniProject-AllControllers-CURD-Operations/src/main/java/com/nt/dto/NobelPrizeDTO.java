package com.nt.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class NobelPrizeDTO implements Serializable{
	private int srno;
	private int nobelId;
    private int year;
    private String laureate;
    private String field;

    public NobelPrizeDTO() {
		System.out.println("NobelPrizeDTO.NobelPrizeDTO()");
	}
    
}
