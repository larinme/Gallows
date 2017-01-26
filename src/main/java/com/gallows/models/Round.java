package com.gallows.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Round {

    @Value("${word}")
    private String rightWord;
    private String maskedWord;

    public Round() {
    }

    @PostConstruct
    public void init() {
        maskedWord = rightWord.replaceAll(".", "_");
    }



}
