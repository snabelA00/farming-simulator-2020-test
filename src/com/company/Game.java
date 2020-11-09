package com.company;

import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    Scanner scanner = new Scanner(System.in);

    public Game(){
        print("\n".repeat(1));
        print("F A R M I N G  S I M U L A T O R  -  2 0 2 0 \n(1 - 4 players)");
        //Start game
        print("\n".repeat(1));
        print("- How many players are you?");
        int numberOfPlayers = 0;
        boolean tryAgain = true;
        while (tryAgain) {
            try {
                numberOfPlayers = Integer.valueOf(scanner.nextLine());
                if(numberOfPlayers < 1 || numberOfPlayers > 4){
                    print("You can only be 1-4 players, try again!");
                    tryAgain = true;
                } else {
                    tryAgain = false;
                }
            } catch (Exception ignored) {
                tryAgain = true;
            }
        }
        print("- Write the name of all the players");
        for(var i = 1; i <= numberOfPlayers; i++) {
            print("- Spelare " + (i) + ":s namn: ");
            String inputPlayerName = scanner.nextLine();
            new Player(inputPlayerName, 50000);
        }
        print("- How many rounds would you like to play? Choose between 5 - 30:");
        int xRounds = 0;
        tryAgain = true;
        while (tryAgain) {
            try {
                xRounds = Integer.valueOf(scanner.nextLine());
                if(xRounds < 5 || xRounds > 30){
                    print("You need to choose between 5-30 rounds, try again!");
                    tryAgain = true;
                } else {
                    tryAgain = false;
                }
            } catch (Exception ignored) {
                tryAgain = true;
            }
        }
        main(xRounds);
    }

    public void main(int numberOfRounds) {

        for (int i = 1; i <= numberOfRounds; i++) {

            for (int player = 0; player < Player.allPlayers.size(); player++) {
                var currentPlayer = Player.allPlayers.get(player);
                if (i == 1) {
                    print("- Lets start with buying your first animal!");
                    Store.buyAnimals(currentPlayer);
                } else {
                    Animal.animalOccurrences(currentPlayer);
                    showList(currentPlayer);
                    moves(currentPlayer);
                    if (currentPlayer.allAnimals.size() > 0) {
                        Animal.reduceHealth(currentPlayer);
                        Animal.checkAnimalHealth(currentPlayer);
                    }
                    print("Press Enter to end of turn");
                    String inputEnter = scanner.nextLine();
                    print("\n".repeat(50));

                    if (!Player.animalLiving(currentPlayer)) {
                        print(currentPlayer.getPlayerName() + " lost all their animals, game over.");
                        Player.allPlayers.remove(currentPlayer);
                        print("\n".repeat(3));
                        gameOver();
                    }
                    if (Player.checkBalance(currentPlayer)){
                        print(currentPlayer.getPlayerName() + " is bankrupt, game over.");
                        Player.allPlayers.remove(currentPlayer);
                        print("\n".repeat(3));
                        gameOver();
                    }
                    Animal.animalsMating(currentPlayer);
                }
            }
        }
    }

    public static void moves(Player currentPlayer){
        Scanner scanner = new Scanner(System.in);
        print("- Lets begin! What's your next move? (write a number)");
        print(" 1. Buy an Animal\n 2. Sell an Animal\n 3. Buy Food\n 4. Feed animals");

        int action = 0;
        boolean tryAgain = true;
        while (tryAgain) {
            try {
                action = Integer.valueOf(scanner.nextLine());
                if (action < 1 || action > 4){
                    print("You need to choose between 1-4, try again!");
                    tryAgain = true;
                } else {
                    tryAgain = false;
                }
            } catch (Exception ignored) {
                tryAgain = true;
            }
        }
        print("\n".repeat(5));
        switch (action) {
            case 1 -> Store.buyAnimals(currentPlayer);
            case 2 -> { if(currentPlayer.allAnimals.size() == 0){
                System.out.println("- You don't own any animals. Try something else!");
                moves(currentPlayer);
            }
                Store.sellAnimals(currentPlayer);}
            case 3 -> Store.buyFood(currentPlayer);
            case 4 -> {
                if (currentPlayer.hayFood.getAmountOfFood() == 0 && currentPlayer.carrotFood.getAmountOfFood() == 0 && currentPlayer.seedFood.getAmountOfFood() == 0) {
                    System.out.println("- Your food storage is empty. Try something else!");
                    moves(currentPlayer);
                }
                Animal.feedAnimal(currentPlayer);
            }
        }
    }

    public static void showList(Player currentPlayer){
        print("- " + currentPlayer.getPlayerName() + "'s turn");
        print("---Balance: " + currentPlayer.getAccountBalance() + "€---");
        // animal list
        System.out.println("---You own " + currentPlayer.allAnimals.size() + " animal(s):");
        for(var animal: currentPlayer.allAnimals) {
            int listIndex = currentPlayer.allAnimals.indexOf(animal);
                print(listIndex + 1 + ". " + animal.getClass().getSimpleName()
                        + ", " + animal.name
                        + ", " + animal.gender
                        + ", " + animal.health + "hp"
                );

        }
        // food list
        System.out.println("\n---Food storage: ");

            print("Hay = " + currentPlayer.hayFood.getAmountOfFood() + "\n- Carrots = " + currentPlayer.carrotFood.getAmountOfFood() + "\n- Seed = " + currentPlayer.seedFood.getAmountOfFood());
    }

    public void gameOver(){
        if(Player.allPlayers.size() == 1){
            print(Player.allPlayers.get(0).getPlayerName() + " won!");
            System.exit(0);
        }
    }

    public static void print(String x){
        if(!x.equals("")){
            System.out.println(x);
        }
    }
}
