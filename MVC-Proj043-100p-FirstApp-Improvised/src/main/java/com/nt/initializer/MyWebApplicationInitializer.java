package com.nt.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMvcAppConfig;

public class MyWebApplicationInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		AnnotationConfigWebApplicationContext rootCtx=null,childCtx=null;
		ContextLoaderListener listener=null;
		DispatcherServlet servlet=null;
		ServletRegistration.Dynamic dynamic=null;
		
		rootCtx=new AnnotationConfigWebApplicationContext();
		rootCtx.register(RootAppConfig.class);
		childCtx=new AnnotationConfigWebApplicationContext();
		childCtx.register(WebMvcAppConfig.class);
		
		listener=new ContextLoaderListener(rootCtx);
		sc.addListener(listener);
		
		servlet=new DispatcherServlet(childCtx);
		dynamic=sc.addServlet("dispatcher", servlet);
		dynamic.addMapping("*.htm");
		dynamic.setLoadOnStartup(2);
		
	}

}
