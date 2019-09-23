package com.nt.bo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class NobelPrizeBO {
	private int nobelId;
    private int year;
    private String laureate;
    private String field;

    public NobelPrizeBO() {
		System.out.println("NobelPrizeBO.NobelPrizeBO()");
	}
    
}
