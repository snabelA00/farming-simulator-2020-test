package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Store {

    Scanner scanner = new Scanner(System.in);

    public void buyAnimals(Player currentPlayer){
        print("- Howdy! Welcome to Joey's Store, what animal are you interested in buying? ");
        print("Horse- " + Horse.animalPrice + "€");
        print("Cow- " + Cow.animalPrice + "€");
        print("Sheep- " + Sheep.animalPrice + "€");
        print("Rabbit- " + Rabbit.animalPrice + "€");
        print("Chicken- " + Chicken.animalPrice + "€");
        var animalToBuy = capitalize(scanner.nextLine().toLowerCase().trim());
        print("- Alrighty! Do you prefer a male or a female? ");
        var animalGenderToBuy = capitalize(scanner.nextLine().toLowerCase().trim());
        print("- Name your new " + animalToBuy.toLowerCase() + ": ");
        String giveName = scanner.nextLine();
        int currentBalance = currentPlayer.getAccountBalance();
        switch(animalToBuy) {
            case "Horse" -> {
                currentPlayer.addAnimal(new Horse(giveName, animalGenderToBuy, 100));
                currentBalance = currentBalance - Horse.animalPrice;
                currentPlayer.setAccountBalance(currentBalance);
            }
            case "Sheep" -> {
                currentPlayer.addAnimal(new Sheep(giveName, animalGenderToBuy, 100));
                currentBalance = currentBalance - Sheep.animalPrice;
                currentPlayer.setAccountBalance(currentBalance);
            }
            case "Rabbit" -> {
                currentPlayer.addAnimal(new Rabbit(giveName, animalGenderToBuy, 100));
                currentBalance = currentBalance - Rabbit.animalPrice;
                currentPlayer.setAccountBalance(currentBalance);
            }
            case "Cow" -> {
                currentPlayer.addAnimal(new Cow(giveName, animalGenderToBuy, 100));
                currentBalance = currentBalance - Cow.animalPrice;
                currentPlayer.setAccountBalance(currentBalance);
            }
            case "Chicken" -> {
                currentPlayer.addAnimal(new Chicken(giveName, animalGenderToBuy, 100));
                currentBalance = currentBalance - Chicken.animalPrice;
                currentPlayer.setAccountBalance(currentBalance);
            }
        }
    }

    public void buyFood(Player currentPlayer){
        print("- Howdy! Welcome to Joey's Store, what animal are you interested in buying? ");
        var foodToBuy = capitalize(scanner.nextLine().toLowerCase().trim());
        int currentBalance = currentPlayer.getAccountBalance();
        switch(foodToBuy) {
            case "Hay" -> {
                currentPlayer.addFood(new Hay());
                currentBalance = currentBalance - Hay.foodPrice;
                currentPlayer.setAccountBalance(currentBalance);
            }
            case "Carrot" -> {
                currentPlayer.addFood(new Carrot());
                currentBalance = currentBalance - Chicken.animalPrice;
                currentPlayer.setAccountBalance(currentBalance);
            }
            case "Seeds" -> {
                currentPlayer.addFood(new Seeds());
                currentBalance = currentBalance - Chicken.animalPrice;
                currentPlayer.setAccountBalance(currentBalance);
            }
        }
    }

    public void sellAnimals(){
        print("- Howdy! Welcome to Joey's Store, write the name of the animal you would like to sell: ");
        var animalToSell = capitalize(scanner.nextLine().toLowerCase().trim());
        print("- Alrighty! You will get 100 dollars for the " + animalToSell.toLowerCase());
        switch(animalToSell) {
            //case "Horse" -> Horse(giveName, animalGenderToBuy);
            //case "Sheep" -> Sheep(giveName, animalGenderToBuy);
            //case "Rabbit" -> Rabbit(giveName, animalGenderToBuy);
           // case "Cow" -> Cow(giveName, animalGenderToBuy);
            //case "Chicken" -> Chicken(giveName, animalGenderToBuy);
        }
    }

    private static String capitalize(String str){
        if(str == null || str.length() == 0)
            return "";
        if(str.length() == 1)
            return str.toUpperCase();
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public void print(String x){
        if(!x.equals("")){
            System.out.println(x);
        }
    }
}
