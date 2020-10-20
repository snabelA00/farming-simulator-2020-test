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
        var input = capitalize(scanner.nextLine().toLowerCase().trim());
        print("- Alrighty! Do you prefer a male or a female? ");
        var animalGenderToBuy = capitalize(scanner.nextLine().toLowerCase().trim());
        print("- Name your new " + input.toLowerCase() + ": ");
        String giveName = scanner.nextLine();
        int currentBalance = currentPlayer.getAccountBalance();
        switch(input) {
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
                currentBalance = currentBalance - Carrot.foodPrice;
                currentPlayer.setAccountBalance(currentBalance);
            }
            case "Seeds" -> {
                currentPlayer.addFood(new Seeds());
                currentBalance = currentBalance - Seeds.foodPrice;
                currentPlayer.setAccountBalance(currentBalance);
            }
        }
    }

    public void sellAnimals(Player currentPlayer){
        print("- Howdy! Welcome to Joey's Store, write the number of the animal you would like to sell: ");
        var input = scanner.nextLine();

        var index = 0;
        try {
            index = Integer.parseInt(input) - 1;
            var action = index < currentPlayer.allAnimals.size() && index >= 0 ? "remove" : "";
            var value = currentPlayer.allAnimals.get(index).getAnimalPrice();
            if (action.equals("remove")) {
                int currentBalance = currentPlayer.getAccountBalance();
                currentPlayer.allAnimals.remove(index);
                currentBalance = currentBalance + value;
                currentPlayer.setAccountBalance(currentBalance);
            }
        }
        catch(Exception ignored){
            }

            //print("- Alrighty! You got" + currentPlayer.allAnimals.get(index) + "for the " + input.toLowerCase());
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
