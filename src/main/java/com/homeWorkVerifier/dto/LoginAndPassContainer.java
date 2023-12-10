package com.homeWorkVerifier.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Getter
@RequiredArgsConstructor
public class LoginAndPassContainer {

    private final Boolean isAvailable;
    private final Map<String, String> logsAndPasswords;
}
