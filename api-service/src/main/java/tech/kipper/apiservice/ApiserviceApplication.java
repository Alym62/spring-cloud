package tech.kipper.apiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiserviceApplication.class, args);
	}

}
