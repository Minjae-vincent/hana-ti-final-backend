package kr.ac.kopo.travel_home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TravelHomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelHomeApplication.class, args);
	}

}
