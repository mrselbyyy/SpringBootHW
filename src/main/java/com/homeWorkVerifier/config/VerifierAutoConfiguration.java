package com.homeWorkVerifier.config;

import com.homeWorkVerifier.dto.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class VerifierAutoConfiguration {

}



