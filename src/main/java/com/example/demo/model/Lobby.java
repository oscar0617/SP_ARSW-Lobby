package com.example.demo.model;

import java.util.ArrayList;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Lobby class
 */
@Data
@Component
public class Lobby {
    private String admin;
    private ArrayList<String> players;
    private Settings settings;
    private Object lock = new Object();

    /**
     * Constructor for lobby
     */
    public Lobby() {
        players = new ArrayList<>();
        settings = new Settings("ffa", 3, true, false, 1.0f, 1);
    }

    /**
     * Adds a player
     * @param nickname nickname of the player to add
     */
    public void addPlayer(String nickname) {
        synchronized(lock) {
            if(players.size() < 4) {
                players.add(nickname);
            }
        }
    }

    /**
     * Removes a player from the lobby
     * @param nickName of the player to remove
     */
    public void removePlayer(String nickName) {
        synchronized(lock) {
            players.remove(nickName);
        }
    }

    /**
     * Returns the number of players on the lobby
     * @return
     */
    public int getNumberPlayers(){
        return players.size();
    }
}