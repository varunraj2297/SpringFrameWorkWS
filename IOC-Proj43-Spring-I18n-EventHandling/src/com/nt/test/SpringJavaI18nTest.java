package com.nt.test;

import java.awt.FlowLayout;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJavaI18nTest {
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		Locale locale=null;
		String cap1=null,cap2=null,cap3=null,cap4=null;
		JFrame frame=null;
		JButton button1=null,button2=null,button3=null,button4=null;
		
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		locale=new Locale(args[0],args[1]);
		cap1=ctx.getMessage("btn.cap1",new Object[]{"emp","dept"}, "msg1", locale);
		cap2=ctx.getMessage("btn.cap2",new Object[]{}, "msg2", locale);
		cap3=ctx.getMessage("btn.cap3",new Object[]{}, "msg3", locale);
		cap4=ctx.getMessage("btn.cap4",new Object[]{}, "msg4", locale);

		frame=new JFrame();
		frame.setLayout(new FlowLayout());
		frame.setSize(300,400);
		frame.setTitle("I18n");
		button1=new JButton(cap1);
		button2=new JButton(cap2);
		button3=new JButton(cap3);
		button4=new JButton(cap4);
		
		frame.add(button1);frame.add(button2);
		frame.add(button3);frame.add(button4);
		
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		((AbstractApplicationContext) ctx).close();
	}
	
}
