package com.gestion.risk;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.gestion.risk.DaO.FilesStorageService;

@SpringBootApplication
public class RiskApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RiskApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
		//storageService.deleteAll();
		//storageService.init();
	}
}