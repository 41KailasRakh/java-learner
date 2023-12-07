package dev.kailas.java8.lambda;

import java.util.Random;

public class ThreadUsingJava8 {

    public void creatingLambdaExpressionForRun(){

        // Creating lambda expression for run() method
        // functional interface 'Runnable'
        Runnable runnable = () -> {
          // Used to set Custom name to the current Thread
          Thread.currentThread().setName("Lambda Tread");
            System.out.println(Thread.currentThread().getName() +" is running");
        };

        // Instantiating thread class by passing Runnable
        // reference to thread constructor
        Thread customThread = new Thread(runnable);

        customThread.run();
    }

    public void multithreadingUsingLambda(){

    }


    public static void main(String[] args) {
        ThreadUsingJava8 threadUsingJava8 = new ThreadUsingJava8();
        System.out.println("Current Main Thread runnig "+ Thread.currentThread().getName());
        threadUsingJava8.creatingLambdaExpressionForRun();

        threadUsingJava8.testMultiThreadingUsingLambda();
        threadUsingJava8.testMultiThreadingUsingLambda();
        threadUsingJava8.testMultiThreadingUsingLambda();
    }

    public void testMultiThreadingUsingLambda(){


        // games and tracks arrays which are being used for
        // picking random items
          String[] games
                = { "COD",      "Prince Of Persia", "GTA-V5",
                "Valorant", "FIFA 22",          "Fortnite" };
          String[] tracks
                = { "Believer", "Cradles", "Taki Taki", "Sorry",
                "Let Me Love You" };


        RandomPlayer player
                = new RandomPlayer(); // Instance of
        // RandomPlayer to access
        // its functionalities

        // Random class for choosing random items from above
        // arrays
        Random random = new Random();

        Runnable gameRunner = () ->{
            try {
                player.playGame(games[random.nextInt(games.length)]);
            }catch (InterruptedException e){
                e.getMessage();
            }
        };

        Runnable musicPlayer = () -> {
          try{
              player.playMusic(tracks[random.nextInt(tracks.length)]);
          }catch (InterruptedException e){
              e.getMessage();
          }
        };

        // Instantiating two thread classes with runnable
        // references
        Thread game = new Thread(gameRunner);
        Thread music = new Thread(musicPlayer);

        // Starting two different threads
        game.start();
        music.start();
    }


    class RandomPlayer {

        public void playGame(String gameName)
                throws InterruptedException
        {

            System.out.println(gameName + " game started");

            // Assuming game is being played for 500
            // milliseconds
            Thread.sleep(500); // this statement may throw
            // interrupted exception, so
            // throws declaration is added

            System.out.println(gameName + " game ended");
        }

        public void playMusic(String trackName)
                throws InterruptedException
        {

            System.out.println(trackName + " track started");

            // Assuming music is being played for 500
            // milliseconds
            Thread.sleep(500); // this statement may throw
            // interrupted exception, so
            // throws declaration is added

            System.out.println(trackName + " track ended");
        }
    }
}
