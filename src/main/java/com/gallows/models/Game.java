package com.gallows.models;

import com.gallows.helpers.GameStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class Game {

    private final Round round;
    private final Score score;
    private final Player player = new Player();

    @Autowired
    public Game(Round round, Score score) {
        this.round = round;
        this.score = score;
    }

    public void attemptLetter(char letter) {
        String newMaskedWord = round.attemptLetter(letter);
        if (newMaskedWord.equals(getMaskedWord())) {
            score.addAttempt();
        }
        round.setMaskedWord(newMaskedWord);
    }

    public String getMaskedWord() {
        return round.getMaskedWord();
    }

    @Override
    public String toString() {
        return MessageFormat.format("Player {0} has {1} and used {2} mistaken attempts", player, round, score);
    }

    public GameStatus getGameStatus() {
        GameStatus gameStatus;
        if (!isLoose() && !areWordsEquals()) {
            gameStatus = GameStatus.CONTINUING;
        } else {
            gameStatus = getResult();
        }
        return gameStatus;
    }

    public int getCountOfAttempts(){
        return score.getCurrentCountOfAttempts();
    }

    public void setPlayerName(String name){
        player.setPlayerName(name);
    }


    private boolean areWordsEquals() {
        return round.areWordsEquals();
    }

    private boolean isLoose() {
        return score.hasAvailableAttempts();
    }

    private GameStatus getResult() {
        GameStatus result;
        if (isLoose()) {
            result = GameStatus.LOSER;
        } else {
            result = GameStatus.WINNER;
        }
        return result;
    }

    public boolean hasAvailableAttempts() {
        return score.hasAvailableAttempts();
    }
}
