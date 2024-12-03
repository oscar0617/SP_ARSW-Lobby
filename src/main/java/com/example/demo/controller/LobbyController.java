package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Settings;
import com.example.demo.service.LobbyService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/lobby")
@CrossOrigin(origins = "*")
public class LobbyController {

    private final LobbyService lobbyService;

    public LobbyController(LobbyService lobbyService) {
        this.lobbyService = lobbyService;
    }

    @PostMapping("/v1/join/{nickName}/{idLobby}")
    public ResponseEntity<Void> joinLobby(@PathVariable String nickName, @PathVariable int idLobby) {
        lobbyService.joinLobby(nickName, idLobby);
        System.out.println("Joined lobby");
        return ResponseEntity.ok().build();
    }

    @PostMapping("/v1/settings/{nickName}/{idRoom}")
    public ResponseEntity<Void> postMethodName(@PathVariable String nickName, @PathVariable int idRoom, @RequestBody Settings settings) {
        if(lobbyService.getAdmin(idRoom).equals(nickName)){
            lobbyService.setSettings(settings, idRoom);
        }
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/v1/settings/{idLobby}")
    @ResponseBody
    public Settings getSettings(@PathVariable int idLobby){
        return lobbyService.getSettings(idLobby);
    }


    @GetMapping("/v1/admin/{lobby}")
    @ResponseBody
    public String getAdmin(@PathVariable int lobby) {
        System.out.println("Admin: " + lobbyService.getAdmin(lobby));
        return lobbyService.getAdmin(lobby);
    }

    @GetMapping("/v1/map/{idLobby}")
    @ResponseBody
    public int getMap(@PathVariable int idLobby) {
        return lobbyService.getSettings(idLobby).getMap();
    }
}
