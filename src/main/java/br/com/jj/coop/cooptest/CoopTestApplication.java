package br.com.jj.coop.cooptest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CoopTestApplication extends ServletInitializer{

	public static void main(String[] args) {
		onApplicationLoaded(SpringApplication.run(CoopTestApplication.class, args));
	}

}
