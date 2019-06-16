package com.nt.advice;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;

public class LoanApproverAdvice {

	/*public void auditing(JoinPoint jp) {
		
		Writer writer = null;
		try {
			writer = new FileWriter("E:/audit.txt", true);
			writer.write(
					jp.getSignature() + " " + Arrays.toString(jp.getArgs()) + " has came for loan approval on " + new Date()+"\n");
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				writer.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}*/
	                              
	public void auditing(/*JoinPoint jt,*/float amt,String manager) {
		                    //JoinPoint is optional if we dont use
		Writer writer = null;
		try {
			writer = new FileWriter("E:/audit.txt", true);
			writer.write(
					amt+ " has to be approve by  " + new Date()+"\n");
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				writer.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}
