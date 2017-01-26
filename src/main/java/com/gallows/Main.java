package com.gallows;

import com.gallows.models.Game;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Game game = context.getBean(Game.class);
        while (game.isGameContinues()){
            System.out.println(game.getMaskedWord());
            Scanner s= new Scanner(System.in);
            char x = s.next().charAt(0);
            game.attemptLetter(x);
            System.out.println(game);
        }
        System.out.println("You are the " + game.getResult() + " with stats: \n" + game);
    }
}
