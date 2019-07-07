package com.nt.handler;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountryHandlerImpl implements Handler {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		Locale locales[]=null;
		String countries[]=null;
		int i=0;
		
		locales=Locale.getAvailableLocales();
		countries=new String[locales.length];
		
		for(Locale locale:locales) {
			countries[i]=locale.getDisplayCountry();
			i++;
		}
		
		req.setAttribute("countries",countries);
		return "country";
	}

}
