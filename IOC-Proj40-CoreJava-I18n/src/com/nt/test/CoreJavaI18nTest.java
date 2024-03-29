package com.nt.test;

import java.awt.FlowLayout;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CoreJavaI18nTest {
	public static void main(String[] args) {
		Locale locale=null;
		ResourceBundle bundle=null;
		String cap1=null,cap2=null,cap3=null,cap4=null;
		JFrame frame=null;
		JButton button1=null,button2=null,button3=null,button4=null;
		
		
		locale=new Locale(args[0],args[1]);
		bundle=ResourceBundle.getBundle("com/nt/commons/App",locale);
		cap1=bundle.getString("btn.cap1");
		cap2=bundle.getString("btn.cap2");
		cap3=bundle.getString("btn.cap3");
		cap4=bundle.getString("btn.cap4");

		frame=new JFrame();
		frame.setLayout(new FlowLayout());
		frame.setSize(300,400);
		frame.setTitle("I18n");
		button1=new JButton(cap1);
		button2=new JButton(cap2);
		button3=new JButton(cap2);
		button4=new JButton(cap2);
		
		frame.add(button1);frame.add(button2);
		frame.add(button3);frame.add(button4);
		
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
