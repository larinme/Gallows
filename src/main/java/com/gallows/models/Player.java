package com.gallows.models;

import org.springframework.stereotype.Component;

@Component
public class Player {

    private String playerName;

    public Player() {

    }

    @Override
    public String toString() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
