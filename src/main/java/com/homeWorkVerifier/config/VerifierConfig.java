package com.homeWorkVerifier.config;

import com.homeWorkVerifier.dto.LogAndPasswordDTO;
import com.homeWorkVerifier.service.VerifierService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VerifierConfig {

    @Bean
    public LogAndPasswordDTO logAndPasswordDTO() {
        return new LogAndPasswordDTO();
    }

    @ConditionalOnProperty(prefix = "check", name = "isAvailable")
    @Bean
    public VerifierService verifierService() {
        return new VerifierService(logAndPasswordDTO());
    }
}



