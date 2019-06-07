package com.wayne.springboot;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.wayne.springboot")
@MapperScan(annotationClass = Mapper.class, basePackages = "com.wayne.springboot")
@EnableScheduling
public class SpringBootShoppingApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootShoppingApplication.class, args);
	}
}
