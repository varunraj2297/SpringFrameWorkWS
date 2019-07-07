package com.nt.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.nt.entity.BankAccount;

@Configuration
@Import(ServiceConfig.class)
@EntityScan(basePackageClasses=BankAccount.class)
@EnableJpaRepositories(basePackages="com.nt.repository")
public class AppConfig {

}
