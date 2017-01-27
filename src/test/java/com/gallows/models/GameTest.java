package com.gallows.models;

import com.gallows.helpers.GameStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

    private String rightWord = "FATHER";
    private Round round = new Round(rightWord);
    private Score score = new Score(5);
    private Game game = new Game(round, score);

    @Before
    public void init() {
        round.buildMaskedWord();
    }

    @Test
    public void supposeCorrectLetter() throws Exception {

        game.attemptLetter('A');
        String maskedWord = game.getMaskedWord();
        Assert.assertEquals("_A____", maskedWord);
        Assert.assertEquals(0, score.getCurrentCountOfAttempts());
        Assert.assertEquals(GameStatus.CONTINUING, game.getGameStatus());
    }

    @Test
    public void supposeIncorrectLetterFirst() throws Exception {

        game.attemptLetter('Z');
        String maskedWord = game.getMaskedWord();
        Assert.assertEquals("______", maskedWord);
        Assert.assertEquals(1, score.getCurrentCountOfAttempts());
        Assert.assertEquals(GameStatus.CONTINUING, game.getGameStatus());
    }

    @Test
    public void supposeIncorrectLetterAndLoseGameByCount() throws Exception {

        game.attemptLetter('Z');
        game.attemptLetter('Z');
        game.attemptLetter('Z');
        game.attemptLetter('Z');
        game.attemptLetter('Z');
        String maskedWord = game.getMaskedWord();
        Assert.assertEquals("______", maskedWord);
        Assert.assertEquals(5, score.getCurrentCountOfAttempts());
        Assert.assertEquals(GameStatus.LOSER, game.getGameStatus());
    }

    @Test
    public void playerWinTheGame() {
        game.attemptLetter('F');
        game.attemptLetter('A');
        game.attemptLetter('T');
        game.attemptLetter('H');
        game.attemptLetter('E');
        game.attemptLetter('r');
        String maskedWord = game.getMaskedWord();
        Assert.assertEquals("FATHER", maskedWord);
        Assert.assertEquals(0, score.getCurrentCountOfAttempts());
        Assert.assertEquals(GameStatus.WINNER, game.getGameStatus());
    }
}