package com.homeWorkVerifier.service;

import com.homeWorkVerifier.dto.LoginAndPassContainer;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
public class VerifierService {
    private final LoginAndPassContainer loginAndPassContainer;

    public VerifierService(LoginAndPassContainer loginAndPassContainer) {
        this.loginAndPassContainer = loginAndPassContainer;
    }

    public void startCheck() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Логины=пароли:");
        System.out.println(loginAndPassContainer.getLogsAndPasswords().toString());

        System.out.println("Введи логин и пароль");
        System.out.println(checkUpOfLoginAndPassword(reader.readLine(), reader.readLine()));
    }

    public String checkUpOfLoginAndPassword(String login, String password) {
        Boolean isAvailable = loginAndPassContainer.getIsAvailable();
        if (isAvailable == null || !isAvailable) {
            return "Проверка не проводится";
        }

        if (loginAndPassContainer.getLogsAndPasswords().containsKey(login)) {
            if (loginAndPassContainer.getLogsAndPasswords().get(login).equals(password)) {
                return "Доступ разрешен";
            }
            return "Неверный пароль";
        }
        return "Неверный логин";
    }
}
