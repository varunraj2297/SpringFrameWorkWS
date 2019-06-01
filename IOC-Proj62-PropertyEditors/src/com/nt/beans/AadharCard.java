package com.nt.beans;

import java.io.File;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

public class AadharCard {
	private String name;
	private long UID;
	private Date dob;
	private char gender;
	private File photo;
	private float age;
	private Currency currencyCode;
	private Locale locale;
	private long[] mobileNos;
	private boolean isHandicapped;
	private char[] favLetters;
	private Reader reader;
	private Pattern pattern;
	private URL linkedInURL;
	private URI linkedInURI;
	private Class curClass;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setUID(long uID) {
		UID = uID;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}
	public void setAge(float age) {
		this.age = age;
	}
	public void setCurrencyCode(Currency currencyCode) {
		this.currencyCode = currencyCode;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	public void setMobileNos(long[] mobileNos) {
		this.mobileNos = mobileNos;
	}
	public void setHandicapped(boolean isHandicapped) {
		this.isHandicapped = isHandicapped;
	}
	public void setFavLetters(char[] favLetters) {
		this.favLetters = favLetters;
	}
	public void setReader(Reader reader) {
		this.reader = reader;
	}
	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}
	public void setLinkedInURL(URL linkedInURL) {
		this.linkedInURL = linkedInURL;
	}
	public void setLinkedInURI(URI linkedInURI) {
		this.linkedInURI = linkedInURI;
	}
	public void setCurClass(Class curClass) {
		this.curClass = curClass;
	}
	@Override
	public String toString() {
		return "AadharCard [name=" + name + ", UID=" + UID + ", dob=" + dob + ", gender=" + gender + ", photo=" + photo
				+ ", age=" + age + ", currencyCode=" + currencyCode + ", locale=" + locale + ", mobileNos="
				+ Arrays.toString(mobileNos) + ", isHandicapped=" + isHandicapped + ", favLetters="
				+ Arrays.toString(favLetters) + ", reader=" + reader + ", pattern=" + pattern + ", linkedInURL="
				+ linkedInURL + ", linkedInURI=" + linkedInURI + ", curClass=" + curClass + "]";
	}
	
	
	
	
	
	
}
