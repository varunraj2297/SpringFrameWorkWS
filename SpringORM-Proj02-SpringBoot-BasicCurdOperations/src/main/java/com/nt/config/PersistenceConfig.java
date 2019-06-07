package com.nt.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.nt.entity.EmployeeHLO;

@Configuration
@ComponentScan(basePackages="com.nt.dao")
public class PersistenceConfig {
	@Autowired
	private DataSource ds;
    
	@Bean(name="sesfact")
	public LocalSessionFactoryBean createLSFB() {
		LocalSessionFactoryBean lsfb=null;
		Properties props=null;
		
		lsfb=new LocalSessionFactoryBean();
		lsfb.setAnnotatedClasses(EmployeeHLO.class);
		lsfb.setDataSource(ds);
		props=new Properties();
		props.put("hibernate.show_sql","true");
		props.put("hibernate.format_sql", "true");
		props.put("hibernate.hbm2ddl.auto","update");
		props.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
         
		lsfb.setHibernateProperties(props);
	    return lsfb;
	}
	
	@Bean
	@Primary
	public SessionFactory createSF() {
		return createLSFB().getObject();
	}
    
	@Bean(name="template")
	public HibernateTemplate createHBTemplate() {
		return new HibernateTemplate(createSF());
	}
}
