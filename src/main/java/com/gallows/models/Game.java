package com.gallows.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Game {

    private final Round round;

    private final Player player;

    private final Score score;

    @Autowired
    public Game(Round round, Player player, Score score) {
        this.round = round;
        this.player = player;
        this.score = score;
    }

    public void attemptLetter(char letter){
        String newMaskedWord = round.attemptLetter(letter);
        if (newMaskedWord.equals(getMaskedWord())){
            score.addAttempt();
        }
        round.setMaskedWord(newMaskedWord);
    }

    public String getMaskedWord(){
        return round.getMaskedWord();
    }


    public Score getScore() {
        return score;
    }
}
