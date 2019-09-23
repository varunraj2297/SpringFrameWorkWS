package com.nt.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMvcAppConfig;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	/*@Override
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
		
	}*/

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {RootAppConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebMvcAppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"*.htm"};
	}

}
