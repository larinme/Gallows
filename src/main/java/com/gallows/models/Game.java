package com.gallows.models;

import com.gallows.helpers.GameStatus;
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

    public Score getScore() { //TODO: DELETE
        return score;
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
}
