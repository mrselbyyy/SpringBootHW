package com.homeWorkVerifier.service;

import com.homeWorkVerifier.dto.LogAndPasswordDTO;
import org.springframework.stereotype.Component;

public class VerifierService {
    private LogAndPasswordDTO accountData;

    public VerifierService(LogAndPasswordDTO accountData) {
        this.accountData = accountData;
    }

    public String checkUpOfLoginAndPassword(String login, String password) {
        if (accountData.getLogsAndPasswords().containsKey(login)) {
            if (accountData.getLogsAndPasswords().get(login).equals(password)) {
                return "Доступ разрешен";
            }
            return "Неверный пароль";
        }
        return "Неверный логин";
    }
}
