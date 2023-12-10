package com.homeWorkVerifier.HWverifierspringbootstarter;

import com.homeWorkVerifier.dto.LoginAndPassContainer;
import com.homeWorkVerifier.service.VerifierService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class ManualTest {

    @DisplayName("Проверка сервиса без спринга")
    @Test
    void justMethodName() {
        HashMap<String, String> map = new HashMap<>();
        map.put("DEFAULT_KEY", "DEFAULT_PASS");

        LoginAndPassContainer loginAndPassContainer = new LoginAndPassContainer(true, map);

        VerifierService verifierService = new VerifierService(loginAndPassContainer);

        String correctValues = verifierService.checkUpOfLoginAndPassword("DEFAULT_KEY", "DEFAULT_PASS");
        String inCorrectLogin = verifierService.checkUpOfLoginAndPassword("test", "1234");
        String inCorrectPassword = verifierService.checkUpOfLoginAndPassword("DEFAULT_KEY", "1234");

        Assertions.assertEquals("Доступ разрешен", correctValues);
        Assertions.assertEquals("Неверный логин", inCorrectLogin);
        Assertions.assertEquals("Неверный пароль", inCorrectPassword);
    }

}
