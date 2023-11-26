package com.homeWorkVerifier.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import java.util.Map;

@ConfigurationProperties(prefix = "verifier-starter")
@Data
public class LogAndPasswordDTO {
    private Map<String, String> logsAndPasswords;

}
