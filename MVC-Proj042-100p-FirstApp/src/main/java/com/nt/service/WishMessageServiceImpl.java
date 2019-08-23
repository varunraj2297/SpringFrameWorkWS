package com.nt.service;

import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service("wishService")
public class WishMessageServiceImpl implements WishMessageService{
     public String getWishMessage() {
    	 Calendar calendar=null;
 		int hours=0;
 		String msg=null;
 		
 		calendar=Calendar.getInstance();
 		hours=calendar.get(Calendar.HOUR_OF_DAY);
 		
 		if(hours<12)
 			msg="Good Morning";
 		else if(hours<16)
 			msg="Good Afternoon";
 		else if(hours<20)
 			msg="Good Evening";
 		else
 			msg="Good Night";
 		
 		return msg;
     }
}
