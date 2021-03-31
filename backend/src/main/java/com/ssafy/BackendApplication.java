package com.ssafy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@MapperScan(basePackages="com.ssafy.pjt.dao")
public class BackendApplication {

	public static void main(String[] args) {
		System.out.println("실행");
		SpringApplication.run(BackendApplication.class, args);
	}

}
