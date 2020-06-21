package com.cxq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cxq.mapper")
public class Day06authApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day06authApplication.class, args);
	}

}
