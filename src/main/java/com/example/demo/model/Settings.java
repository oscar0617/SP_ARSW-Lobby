package com.example.demo.model;

import lombok.Data;

/**
 * Settings class
 */
@Data
public class Settings {
    private String gameMode;
    private int maxJumps;
    private boolean boost;
    private boolean obstacles;
    private float speed;
    private int map;

    /**
     * Constructor for settings
     */
    public Settings(){
    }

    /**
     * Constructor for settings
     * @param gameMode
     * @param maxJumps
     * @param boost
     * @param obstacles
     * @param speed
     * @param map
     */
    public Settings(String gameMode, int maxJumps, boolean boost, boolean obstacles, float speed, int map){
        this.gameMode = gameMode;
        this.maxJumps = maxJumps;
        this.boost = boost;
        this.obstacles = obstacles;
        this.speed = speed;
        this.map = map;
    }
}
