package com.example.demo.service;

import java.util.ArrayList;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.demo.model.Lobby;
import com.example.demo.model.Settings;

/**
 * Lobby service
 */
@Service
@Component
public class LobbyService {

    private ArrayList<Lobby> lobbies = new ArrayList<>(); 

    /**
     * Sets an admin for the lobby
     * @param nickName admin's nickname
     * @param idLobby identifier of the lobby
     */
    public void setAdmin(String nickName, int idLobby){
        Lobby lobby = lobbies.get(idLobby - 1);
        lobby.setAdmin(nickName);
        System.out.println(nickName);
    }

    /**
     * Joins a player to a lobby
     * @param nickName player's name 
     * @param idLobby identifier of the lobby
     */
    public synchronized void joinLobby(String nickName, int idLobby){
        if(lobbies.isEmpty() ){
            for(int i = 0; i < 4; i++){
                lobbies.add(new Lobby());
            }
        }
        System.out.println(lobbies.size());
        Lobby lobby = lobbies.get(idLobby - 1);
        if(lobby.getAdmin() == null){
            lobby.setAdmin(nickName);
        }
        lobby.addPlayer(nickName);
        System.out.println(lobby.getNumberPlayers() + " " + lobby.getAdmin());
    }

    /**
     * Returns the settings of the lobby
     * @param idLobby identifier of the lobby
     * @return
     */
    public Settings getSettings(int idLobby){
        return lobbies.get(idLobby - 1).getSettings();
    }

    /**
     * Sets the settings for the lobby
     * @param settings settings to set
     * @param idLobby identifier of the lobby
     */
    public void setSettings(Settings settings, int idLobby){
        lobbies.get(idLobby - 1).setSettings(settings);
    }
    
    /**
     * Returns the admin of the lobby
     * @param idLobby identifier of the lobby
     * @return
     */
    public String getAdmin(int idLobby){
        return lobbies.get(idLobby - 1).getAdmin();
    }

}