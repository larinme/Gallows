package com.gallows.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

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
    private boolean areWordsEquals(){
        return round.areWordsEquals();
    }


    public Score getScore() {
        return score;
    }

    public boolean isLoose(){
        return score.isCurrentCountOfAttemptsMoreOrEqualsThanMaxCount();
    }

    public boolean isWin(){
        return !isLoose() && areWordsEquals();

    }
    public boolean isGameContinues(){
        return !isLoose() && !areWordsEquals();

    }

    public String getResult(){
        String result;
        if (isLoose()){
            result = "Loser";
        } else{
            result = "Winner";
        }
        return  result;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Player {0} has mask {1} and used {2} mistaken attempts", player, round, score);
    }
}
