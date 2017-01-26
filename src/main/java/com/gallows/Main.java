package com.gallows;

import com.gallows.models.Game;
import com.gallows.helpers.GameStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.LogManager;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        System.out.println("=====================================================");
        Game game = context.getBean(Game.class);
        while (game.getGameStatus().equals(GameStatus.CONTINUING)) {
            System.out.println(game.getMaskedWord());
            Scanner s = new Scanner(System.in);
            char x = s.next().charAt(0);
            game.attemptLetter(x);
            System.out.println(game);
        }
        System.out.println("You are the " + game.getGameStatus());
    }
}
