package com.nt.serviceloactor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.FactoryBean;

import com.nt.externalcomp.ExternalServiceComp;
import com.nt.externalcomp.ExternalServiceCompImpl;

public class IPLScoreCompServiceLocatorFactoryBean implements FactoryBean<ExternalServiceComp>{

	private String jndi;
	//private ExternalServiceComp ext=null;
	private Map<String,ExternalServiceComp> cacheMap;

	public IPLScoreCompServiceLocatorFactoryBean(String jndi) {
		this.jndi = jndi;
		cacheMap=new HashMap<String, ExternalServiceComp>();
	}
	@Override
	public ExternalServiceComp getObject() throws Exception {
		if(!cacheMap.containsKey(jndi)) {
			cacheMap.put(jndi,new ExternalServiceCompImpl());
		}
		return cacheMap.get(jndi);
	}

	@Override
	public Class<ExternalServiceComp> getObjectType() {
		// TODO Auto-generated method stub
		return ExternalServiceComp.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
