package com.gallows;

import com.gallows.models.Game;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Game game = context.getBean(Game.class);
        System.out.println(game);
    }
}
