package com.example.springboard.api.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Base64;

@Data
@Configuration
@ConfigurationProperties(prefix = "mixoo")
public class AppConfig {

    private byte[] jwtKey;

    public void setJwtKey(String jwtKey) {
        this.jwtKey = Base64.getDecoder().decode(jwtKey);
    }

    public byte[] getJwtKey() {
        return jwtKey;
    }
}
