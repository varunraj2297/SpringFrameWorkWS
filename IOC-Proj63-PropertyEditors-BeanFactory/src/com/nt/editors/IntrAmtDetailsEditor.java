package com.nt.editors;

import java.beans.PropertyEditorSupport;

import com.nt.beans.IntrAmtDetails;

public class IntrAmtDetailsEditor extends PropertyEditorSupport{

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		float principle=0.0f;
		float rate=0.0f;
		float time=0.0f;
		
		principle=Float.parseFloat(text.substring(0,text.indexOf(",")));
		time=Float.parseFloat(text.substring(text.indexOf(",")+1,text.lastIndexOf(",")));
		rate=Float.parseFloat(text.substring(text.lastIndexOf(",")+1,text.length()));
		
		IntrAmtDetails details=new IntrAmtDetails();
		
		details.setPrinciple(principle);
		details.setRate(rate);
		details.setTime(time);
		
		setValue(details);
	
	}

	
}
