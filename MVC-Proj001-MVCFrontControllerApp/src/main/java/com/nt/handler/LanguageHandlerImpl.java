package com.nt.handler;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LanguageHandlerImpl implements Handler {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		Locale locales[]=null;
		String langs[]=null;
		int i=0;
		
		locales=Locale.getAvailableLocales();
		langs=new String[locales.length];
		
		for(Locale locale:locales) {
			langs[i]=locale.getDisplayLanguage();
			i++;
		}
		
		req.setAttribute("langs",langs);
		return "lang";
	}

}
