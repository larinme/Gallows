package com.gallows.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Player {

    @Value("${playerName}")
    private String playerName;
    public Player(){

    }

    @Override
    public String toString() {
        return playerName;
    }
}
