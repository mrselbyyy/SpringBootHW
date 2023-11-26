package com.homeWorkVerifier;

import com.homeWorkVerifier.dto.LogAndPasswordDTO;
import com.homeWorkVerifier.service.VerifierService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class HwVerifierSpringBootStarterApplication {

	public static void main(String[] args) throws IOException {
		ApplicationContext context = SpringApplication.run(HwVerifierSpringBootStarterApplication.class, args);

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		try{
			VerifierService service = context.getBean(VerifierService.class);

			LogAndPasswordDTO logAndPasswordDTO = context.getBean(LogAndPasswordDTO.class);

			System.out.println("Логины=пароли:");
			System.out.println(logAndPasswordDTO.getLogsAndPasswords().toString());

			System.out.println("Введи логин и пароль");
			System.out.println(service.checkUpOfLoginAndPassword(reader.readLine(), reader.readLine()));
		} catch (Exception e){
			System.out.println("----------------");
			System.out.println(e.getMessage());
		}
	}

}
