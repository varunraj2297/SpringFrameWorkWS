package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.nt.comps.Vehicle;

@Configuration
@ComponentScan(basePackages="com.nt.comps")
public class AppConfig {

}
