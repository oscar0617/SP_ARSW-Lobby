package com.example.demo.config;

import com.example.demo.model.Lobby;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for Lobby
 */
@Configuration
public class LobbyConfig {
    
    /**
     * Creates a lobby
     */
    @Bean
    public Lobby lobby() {
        return new Lobby();
    }
}