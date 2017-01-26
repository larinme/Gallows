package com.gallows.models;

import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Round {

    private String rightWord;

    private String maskedWord;

    public Round(
            @Value("${word}") String rightWord
    ) {
        this.rightWord = rightWord.toUpperCase();
    }

    @PostConstruct
    public void buildMaskedWord() {
        maskedWord = Strings.repeat("_", rightWord.length());
    }

    public String getMaskedWord() {
        return maskedWord;
    }

    public String attemptLetter(char attempt) {

        String letter = String.valueOf(attempt).toUpperCase();

        char[] rightChars = rightWord.toCharArray();
        char[] maskedChars = maskedWord.toCharArray();

        for (int i = 0; i < rightChars.length; i++) {
            if (rightChars[i] == letter.charAt(0)){
                maskedChars[i] = rightChars[i];
            }
        }

        return new String(maskedChars);
    }

    public boolean areWordsEquals(){
        return maskedWord.equals(rightWord);
    }

    public void setMaskedWord(String maskedWord) {
        this.maskedWord = maskedWord;
    }

    @Override
    public String toString() {
        return "Masked Word='" + maskedWord + '\'';
    }
}
