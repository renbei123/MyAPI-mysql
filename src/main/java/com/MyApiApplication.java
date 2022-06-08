package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MyApiApplication extends SpringBootServletInitializer {

    //打war包时需要继承SpringBootServletInitializer，重写configure方法
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MyApiApplication.class);
    }
	public static void main(String[] args) {
		SpringApplication.run(MyApiApplication.class, args);

	}

}

