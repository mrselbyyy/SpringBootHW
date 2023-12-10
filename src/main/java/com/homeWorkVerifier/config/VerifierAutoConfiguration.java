package com.homeWorkVerifier.config;

import com.homeWorkVerifier.dto.LoginAndPassContainer;
import com.homeWorkVerifier.dto.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
@EnableConfigurationProperties({SecurityProperties.class, SecurityProperties.class})
public class VerifierAutoConfiguration {

    private final SecurityProperties securityProperties;

    public VerifierAutoConfiguration(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    @Bean
    public LoginAndPassContainer getLogPassContainer() {
        HashMap<String, String> map = new HashMap<>();

        if (securityProperties.isAvailable == null || !securityProperties.isAvailable)
            return new LoginAndPassContainer(false, map);

        if (securityProperties.logsAndPasswords == null || securityProperties.logsAndPasswords.isEmpty()) {
            map.put("DEFAULT_KEY", "DEFAULT_PASS");
        } else {
            map.putAll(securityProperties.logsAndPasswords);
        }


        return new LoginAndPassContainer(true, map);
    }
}



