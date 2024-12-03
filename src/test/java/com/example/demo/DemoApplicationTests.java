package com.example.demo;

import com.example.demo.service.LobbyService;
import com.example.demo.model.Settings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DemoApplicationTests {

    private LobbyService lobbyService;

    @BeforeEach
    public void setUp() {
        lobbyService = new LobbyService();
    }

    @Test
    void testSetAdmin() {
        lobbyService.joinLobby("Player1", 1);
        lobbyService.setAdmin("Player2", 1);
        assertEquals("Player2", lobbyService.getAdmin(1));
    }

    @Test
    void testGetSettings_DefaultSettings() {
        lobbyService.joinLobby("Player1", 1);
        Settings settings = lobbyService.getSettings(1);
        assertNotNull(settings);
    }

    @Test
    void testJoinLobby() {
        lobbyService.joinLobby("Player1", 1);
        assertEquals("Player1", lobbyService.getAdmin(1));
        assertNotNull(lobbyService.getSettings(1));
    }

    @Test
    void testJoinMultiplePlayers() {
        lobbyService.joinLobby("Player1", 1);
        lobbyService.joinLobby("Player2", 1);
        assertEquals("Player1", lobbyService.getAdmin(1));
    }
}
