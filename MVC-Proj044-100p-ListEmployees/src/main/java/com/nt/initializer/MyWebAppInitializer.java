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

public class MyWebAppInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		
		AnnotationConfigWebApplicationContext parentCtx=null,childCtx=null;
		ContextLoaderListener listener=null;
		DispatcherServlet ds=null;
		ServletRegistration.Dynamic dynamic=null;
		
		parentCtx=new AnnotationConfigWebApplicationContext();
		parentCtx.register(RootAppConfig.class);
		listener=new ContextLoaderListener(parentCtx);
		sc.addListener(listener);
		
		childCtx=new AnnotationConfigWebApplicationContext();
		childCtx.register(WebMvcAppConfig.class);
		ds=new DispatcherServlet(childCtx);
		dynamic=sc.addServlet("dispatcher",ds);
		dynamic.addMapping("*.htm");
		dynamic.setLoadOnStartup(2);
		
	}

}
