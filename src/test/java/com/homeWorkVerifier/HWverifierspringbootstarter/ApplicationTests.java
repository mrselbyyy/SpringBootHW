package com.homeWorkVerifier.HWverifierspringbootstarter;

import com.homeWorkVerifier.dto.LoginAndPassContainer;
import com.homeWorkVerifier.service.NoBeanService;
import com.homeWorkVerifier.service.VerifierService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

import static org.mockito.Mockito.when;

@SpringBootTest
class ApplicationTests {

    @Autowired
    public ApplicationContext context;

    @Autowired
    public VerifierService verifierService;

    @MockBean
    public LoginAndPassContainer loginAndPassContainer;

    @DisplayName("Проверка инициализации контекста")
    @Test
    void contextLoads() {
    }

    @DisplayName("Проверка получения бина из контекста")
    @Test
    void correctTestContext() {
        VerifierService verifierService = context.getBean(VerifierService.class);
        Assertions.assertNotNull(verifierService);
    }


    @DisplayName("Проверка выброса исключения при запросе несуществующего бина из контекста")
    @Test
    void incorrectTestContext() {
        Assertions.assertThrows(
                NoSuchBeanDefinitionException.class,
                () -> {
                    context.getBean(NoBeanService.class);
                }
        );
    }

    @DisplayName("Проверка работы сервиса verifier, на проверку логина и пароля")
    @Test
    void testVerifierService() {
        String correctValues = verifierService.checkUpOfLoginAndPassword("test", "test");
        String inCorrectLogin = verifierService.checkUpOfLoginAndPassword("incorrect_login", "123");
        String inCorrectPassword = verifierService.checkUpOfLoginAndPassword("test", "1234");

        Assertions.assertEquals("Доступ разрешен", correctValues);
        Assertions.assertEquals("Неверный логин", inCorrectLogin);
        Assertions.assertEquals("Неверный пароль", inCorrectPassword);
    }

    @Test
    void testVerifierServiceMock() {
        when(loginAndPassContainer.getIsAvailable()).thenReturn(Boolean.TRUE);

        String result = verifierService.checkUpOfLoginAndPassword("test", "test");
        Assertions.assertEquals("Доступ разрешен", result);
    }

    @Disabled
    @DisplayName("Игнорируемый тест")
    @Test
    void ignoredTest() {

    }
}
