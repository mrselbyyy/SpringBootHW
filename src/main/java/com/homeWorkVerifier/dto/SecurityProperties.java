package com.homeWorkVerifier.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@Data
@ConfigurationProperties(prefix = "verifier-starter")
public class SecurityProperties {

    public Boolean isAvailable;

    public Map<String, String> logsAndPasswords;

}
