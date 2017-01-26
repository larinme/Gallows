package com.gallows.models;

import org.junit.Assert;
import org.junit.Test;

import java.text.MessageFormat;

import static org.junit.Assert.assertEquals;

public class RoundTest {


    private String rightWord = "FATHER";
    private Round round = new Round(rightWord);

    @Test
    public void checkReturnValueWhenIncorrectAttempts() {

        round.buildMaskedWord();
        String result = round.attemptLetter('с');
        assertEquals(
                MessageFormat.format(
                        "result = {0} (actualLength = {1}) (rightWordLength = {2})",
                        result,
                        result.length(),
                        rightWord.length()),
                "______",
                result
        );
    }

    @Test
    public void oneSuitableLetterWhenCorrectAttempts() {

        round.buildMaskedWord();
        String result = round.attemptLetter('a');
        assertEquals(
                MessageFormat.format(
                        "result = {0} (length = {1}) (rightWordLength = {2})",
                        result,
                        result.length(),
                        rightWord.length()
                ),
                "_A____",
                result
        );
    }

    @Test
    public void moreThanOneSuitableLetterWhenCorrectAttempts() {

        String wordWithRepeatedLetter = "dependency";
        round = new Round(wordWithRepeatedLetter);
        round.buildMaskedWord();
        String result = round.attemptLetter('e');
        assertEquals(
                MessageFormat.format(
                        "result = {0} (length = {1}) (rightWordLength = {2})",
                        result,
                        result.length(),
                        wordWithRepeatedLetter.length()
                ),
                "_E_E__E___",
                result
        );
    }

    @Test
    public void checkCorrectnessOfBuiltMaskedWord(){
        round.buildMaskedWord();

        String maskedWord = round.getMaskedWord();

        assertEquals("______", maskedWord);
    }

    @Test
    public void checkIncorrectnessOfBuiltMaskedWord(){
        round.buildMaskedWord();

        String maskedWord = round.getMaskedWord();

        Assert.assertFalse("___".equals(maskedWord));
    }
}