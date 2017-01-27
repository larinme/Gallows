package com.gallows;

import com.gallows.helpers.GameStatus;
import com.gallows.models.Game;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Game game = context.getBean(Game.class);
        System.out.println("Please, input your name:");
        game.setPlayerName(new Scanner(System.in).next());
        while (game.getGameStatus().equals(GameStatus.CONTINUING)) {
            System.out.println(MessageFormat.format("Mask: {0}", game.getMaskedWord()));
            Scanner s = new Scanner(System.in);
            char x = s.next().charAt(0);
            game.attemptLetter(x);
            System.out.println(game);
        }
        System.out.println("You are the " + game.getGameStatus());
    }
}
