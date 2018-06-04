package com.example.demo;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(order = 10) //开启事务，并设置order值，默认是Integer的最大值
@ComponentScan(basePackages={"com.example.demo"})
public class SpringbootDruidApplication {

	Logger logger = Logger.getLogger(SpringbootDruidApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDruidApplication.class, args);
	}
}
