package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@Component("props")
//@PropertySource(value={"classpath:com/nt/commons/info.properties","classpath:com/nt/commons/info1.properties"})

/*
@PropertySource("classpath:com/nt/commons/info1.properties")
@PropertySource("classpath:com/nt/commons/info.properties")
*/

//@PropertySources(value= {@PropertySource(value={"classpath:com/nt/commons/info.properties","classpath:com/nt/commons/info1.properties"})})
@PropertySources(value= {@PropertySource("classpath:com/nt/commons/info1.properties"),@PropertySource("classpath:com/nt/commons/info.properties")})
public class PropsBean {
	
   @Value("${user.uname}")
   private String name;
   @Value("${user.addrs}")
   private String addrs;
   @Value("${user.age}")
   private int age;
   @Value("${os.name}")
   private String os;
   @Value("${JAVA_HOME}")
   private String jdk;
   
   @Override
   public String toString() {
	   return "PropsBean [name=" + name + ", addrs=" + addrs + ", age=" + age + ", os=" + os + ", jdk=" + jdk + "]";
   }
   
}
