package com.gallows.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Score {

    private Integer maxCountOfAttempts;

    private int currentCountOfAttempts = 0;

    public Score(
            @Value("#{T(java.lang.Integer).parseInt(${attempts})}") int maxCountOfAttempts
    ) {
        this.maxCountOfAttempts = maxCountOfAttempts;
    }

    public boolean isCurrentCountOfAttemptsLessOrEqualThanMaxCount() {

        return currentCountOfAttempts < maxCountOfAttempts;
    }

    public void addAttempt() {
        currentCountOfAttempts++;
    }


    public int getMaxCountOfAttempts() {
        return maxCountOfAttempts;
    }

    public int getCurrentCountOfAttempts() {
        return currentCountOfAttempts;
    }
}
