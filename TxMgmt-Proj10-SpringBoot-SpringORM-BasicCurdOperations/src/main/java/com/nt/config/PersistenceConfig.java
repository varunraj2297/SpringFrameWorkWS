package com.nt.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.nt.entity.BankAccount;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
public class PersistenceConfig {

	@Autowired
	private DataSource ds;

	@Bean(name="localSesFact")
	public LocalSessionFactoryBean createLSFB() {
		LocalSessionFactoryBean lsfb = null;
		Properties properties = null;

		lsfb = new LocalSessionFactoryBean();
		lsfb.setDataSource(ds);
		lsfb.setAnnotatedClasses(BankAccount.class);
		lsfb.setAnnotatedPackages("com.nt.entity");
		properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		lsfb.setHibernateProperties(properties);
		
		return lsfb;
	}
	
	@Bean(name="ht")
	public HibernateTemplate createHT() {
		return new HibernateTemplate(createLSFB().getObject());
	}
}
