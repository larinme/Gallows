package com.gallows.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

    private String rightWord = "FATHER";
    private Round round = new Round(rightWord);
    private Score score = new Score(5);
    private Player player = new Player();
    private Game game = new Game(round, player, score);

    @Before
    public void init(){
        round.buildMaskedWord();
    }

    @Test
    public void supposeCorrectLetter() throws Exception {

        game.attemptLetter('A');
        String maskedWord = game.getMaskedWord();
        Assert.assertEquals("_A____", maskedWord);
        Assert.assertEquals(0, game.getScore().getCurrentCountOfAttempts());
        Assert.assertEquals(true, game.getScore().isCurrentCountOfAttemptsLessOrEqualThanMaxCount());
    }

    @Test
    public void supposeIncorrectLetterFirst() throws Exception {

        game.attemptLetter('Z');
        String maskedWord = game.getMaskedWord();
        Assert.assertEquals("______", maskedWord);
        Assert.assertEquals(1, game.getScore().getCurrentCountOfAttempts());
        Assert.assertEquals(true, game.getScore().isCurrentCountOfAttemptsLessOrEqualThanMaxCount());
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
        Assert.assertEquals(5, game.getScore().getCurrentCountOfAttempts());
        Assert.assertEquals(false, game.getScore().isCurrentCountOfAttemptsLessOrEqualThanMaxCount());
    }
}