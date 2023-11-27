package com.homeWorkVerifier.service;

import com.homeWorkVerifier.dto.SecurityProperties;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
public class VerifierService {
    private final SecurityProperties securityProperties;

    public VerifierService(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    public void startCheck() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Логины=пароли:");
        System.out.println(securityProperties.getLogsAndPasswords().toString());

        System.out.println("Введи логин и пароль");
        System.out.println(checkUpOfLoginAndPassword(reader.readLine(), reader.readLine()));
    }

    public String checkUpOfLoginAndPassword(String login, String password) {
        Boolean isAvailable = securityProperties.getIsAvailable();
        if (isAvailable == null || !isAvailable) {
            return "Проверка не проводится";
        }

        if (securityProperties.getLogsAndPasswords().containsKey(login)) {
            if (securityProperties.getLogsAndPasswords().get(login).equals(password)) {
                return "Доступ разрешен";
            }
            return "Неверный пароль";
        }
        return "Неверный логин";
    }
}
