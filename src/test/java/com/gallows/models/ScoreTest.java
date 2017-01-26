package com.gallows.models;

import org.junit.Test;

import java.text.MessageFormat;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ScoreTest {

    private Score score = new Score(5);

    @Test
    public void checkStartCountOfAttemptsLessOrEqualThanMaxCount(){

        assertTrue(score.isCurrentCountOfAttemptsLessOrEqualThanMaxCount());
    }

    @Test
    public void checkAnyLegalAttemptDoesNotFinishARound(){

        score.addAttempt();
        score.addAttempt();
        score.addAttempt();
        int currentCountOfAttempts = score.getCurrentCountOfAttempts();
        int maxCountOfAttempts = score.getMaxCountOfAttempts();
        assertTrue(
                MessageFormat.format(
                        "actual current count = {0}, max = {1}",
                        currentCountOfAttempts,
                        maxCountOfAttempts),
                score.isCurrentCountOfAttemptsLessOrEqualThanMaxCount());
    }

    @Test
    public void checkGameLoses(){
        score.addAttempt();
        score.addAttempt();
        score.addAttempt();
        score.addAttempt();
        score.addAttempt();
        int currentCountOfAttempts = score.getCurrentCountOfAttempts();
        int maxCountOfAttempts = score.getMaxCountOfAttempts();
        assertFalse(
                MessageFormat.format(
                        "actual current count = {0}, max = {1}",
                        currentCountOfAttempts,
                        maxCountOfAttempts),
                score.isCurrentCountOfAttemptsLessOrEqualThanMaxCount());
    }

}