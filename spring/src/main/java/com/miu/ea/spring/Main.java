package com.miu.ea.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        //xmlConfigMethod();
        javaConfigMethod();
    }

    private static void xmlConfigMethod() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //Vehicle car = context.getBean(Car.class);
        //Game game = context.getBean(Game.class);
//        Scope Test
//        Bike bike = context.getBean("bike", Bike.class);
//        System.out.println("The instance of Bike "+bike);
//        Bike bike1 = context.getBean("bike", Bike.class);
//        System.out.println("The instance of Bike "+bike1);

        Game game = context.getBean(Game.class);
        System.out.println("The game instance :"+ game);
        Game game1 = context.getBean(Game.class);
        System.out.println("The game1 instance :"+ game1);

        System.out.println("The instance of game v "+game.getVehicle());
        System.out.println("The instance of game1 v "+game1.getVehicle());

        System.out.println("6. Main class Get Bean called");
        //Game game1 = context.getBean("game",Game.class);
        game.playGame();
        System.out.println(game.getBrand());
    }

    private static void javaConfigMethod() throws Exception {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.miu.ea.spring");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);


        //context.registerShutdownHook();
        //context.close();
        //Method DI -
        // If vehicle is prototype bean and game is singleton bean then every time
        // then game return singleton vehicle with constructor method
        //This is can be acheived using awareinterface but it is couple with spring
        // and also we can get using Method DI
        Game game = context.getBean(Game.class);
        System.out.println("The game instance :"+ game);
        Game game1 = context.getBean(Game.class);
        System.out.println("The game1 instance :"+ game1);

        System.out.println("The instance of game v "+game.getVehicle());
        System.out.println("The instance of game1 v "+game1.getVehicle());
//        Bike bike = context.getBean("bike", Bike.class);
//        System.out.println("The instance of Bike "+bike);
//        Bike bike1 = context.getBean("bike", Bike.class);
//        System.out.println("The instance of Bike1 "+bike1);
        //ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigMixed.class);
        //Vehicle car = context.getBean(Car.class);
        //Game game = context.getBean(Game.class);
        //game.playGame();
        //scope test

        //System.out.println("The bike(scope) has been destroyed"+bike);

        //System.out.println("6. Main class Get Bean called");



        game.playGame();
        System.out.println(game.getBrand());

    }
}
