package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;

@Service
public class LocaleServiceImpl implements LocaleService{
	
	private Locale[] locales;

	
	public LocaleServiceImpl() {
		locales=Locale.getAvailableLocales();
	}

	@Override
	public List<String> getAllLanguages() {
		List<String> languages=null;
		
		languages=new ArrayList<>();
		
		for(Locale locale:locales) {
			languages.add(locale.getDisplayLanguage());
		}
		
		return languages;
	}

	@Override
	public List<String> getAllCountries() {
		List<String> countries=null;
		
		countries=new ArrayList<>();
		
		for(Locale locale:locales) {
			countries.add(locale.getDisplayCountry());
		}
		
		return countries;
	}
     
	
}
