package com.ypf.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement//开启事务管
public class FowerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FowerApplication.class, args);
	}
}
