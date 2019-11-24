package com.everydaymall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.everydaymall.mapper")
@SpringBootApplication
public class EverydaymallApplication {

	public static void main(String[] args) {
		SpringApplication.run(EverydaymallApplication.class, args);
	}

}
