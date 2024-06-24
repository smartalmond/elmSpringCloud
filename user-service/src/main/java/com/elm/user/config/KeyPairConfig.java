package com.elm.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

@Configuration
public class KeyPairConfig {

    @Bean
    public KeyPair keyPair() throws NoSuchAlgorithmException {
        // 使用 KeyPairGenerator 生成 RSA 密钥对
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // 可以指定密钥长度，例如 2048 位
        return keyPairGenerator.generateKeyPair();
    }
}
