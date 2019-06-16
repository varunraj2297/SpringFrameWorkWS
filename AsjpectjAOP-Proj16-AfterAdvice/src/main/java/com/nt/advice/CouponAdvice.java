package com.nt.advice;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.aspectj.lang.JoinPoint;

public class CouponAdvice {

	public void audit(JoinPoint jp,String returnValue) {
		Writer writer = null;
		String couponMsg = null;
		Float billAmount = 0.0f;

		billAmount = Float.parseFloat(((String) returnValue).substring(((String) returnValue).indexOf("::") + 2,
				((String) returnValue).length()));
		// billAmount=(Float)returnValue;
		// billAmount=50000.0f;
		if (billAmount > 50000)
			couponMsg = "50% discount on next purchase";
		else if (billAmount > 40000)
			couponMsg = "40% discount on next purchase";
		else if (billAmount > 30000)
			couponMsg = "30% discount on next purchase";
		else if (billAmount > 20000)
			couponMsg = "20% discount on next purchase";
		else
			couponMsg = "10% discount on next purchase";

		try {
			writer = new FileWriter("E:/coupon.txt");
			writer.write(couponMsg);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
