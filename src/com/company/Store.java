package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Store {

    private static Scanner scanner = new Scanner(System.in);
    public static void buyAnimals(Player currentPlayer) {
        Game.showList(currentPlayer);
        if (currentPlayer.getAccountBalance() < 5000) {
            print("You don't have enough money to buy an animal. Try something else!");
            Game.moves(currentPlayer);
        }
        print("- Howdy! Welcome to Joey's Store, what animal are you interested in buying? ");
        print("--> Horse- " + Horse.animalPrice + "€");
        print("--> Cow- " + Cow.animalPrice + "€");
        print("--> Sheep- " + Sheep.animalPrice + "€");
        print("--> Rabbit- " + Rabbit.animalPrice + "€");
        print("--> Chicken- " + Chicken.animalPrice + "€");
        try {
            String animalInput = capitalize(scanner.nextLine().toLowerCase().trim());
        int currentBalance = currentPlayer.getAccountBalance();
        switch (animalInput) {
            case "Horse" -> {
                print("- Alrighty! Do you prefer a male or a female? ");
                String animalGenderToBuy = capitalize(scanner.nextLine().toLowerCase().trim());
                if(!animalGenderToBuy.equals("Male") && !animalGenderToBuy.equals("Female")){
                    print("\n".repeat(5) + "Input isn't valid, try again!");
                    buyAnimals(currentPlayer);
                }
                print("- Name your new " + animalInput.toLowerCase() + ": ");
                String giveName = scanner.nextLine();
                currentPlayer.addAnimal(new Horse(animalInput, giveName, animalGenderToBuy, 100), currentPlayer);
                currentBalance = currentBalance - Horse.animalPrice;
                currentPlayer.setAccountBalance(currentBalance);
            }
            case "Sheep" -> {
                print("- Alrighty! Do you prefer a male or a female? ");
                var animalGenderToBuy = capitalize(scanner.nextLine().toLowerCase().trim());
                if(!animalGenderToBuy.equals("Male") && !animalGenderToBuy.equals("Female")){
                    print("\n".repeat(5) + "Input isn't valid, try again!");
                    buyAnimals(currentPlayer);
                }
                print("- Name your new " + animalInput.toLowerCase() + ": ");
                String giveName = scanner.nextLine();
                currentPlayer.addAnimal(new Sheep(animalInput, giveName, animalGenderToBuy, 100), currentPlayer);
                currentBalance = currentBalance - Sheep.animalPrice;
                currentPlayer.setAccountBalance(currentBalance);
            }
            case "Rabbit" -> {
                print("- Alrighty! Do you prefer a male or a female? ");
                var animalGenderToBuy = capitalize(scanner.nextLine().toLowerCase().trim());
                if(!animalGenderToBuy.equals("Male") && !animalGenderToBuy.equals("Female")){
                    print("\n".repeat(5) + "Input isn't valid, try again!");
                    buyAnimals(currentPlayer);
                }
                print("- Name your new " + animalInput.toLowerCase() + ": ");
                String giveName = scanner.nextLine();
                currentPlayer.addAnimal(new Rabbit(animalInput, giveName, animalGenderToBuy, 100), currentPlayer);
                currentBalance = currentBalance - Rabbit.animalPrice;
                currentPlayer.setAccountBalance(currentBalance);
            }
            case "Cow" -> {
                print("- Alrighty! Do you prefer a male or a female? ");
                var animalGenderToBuy = capitalize(scanner.nextLine().toLowerCase().trim());
                if(!animalGenderToBuy.equals("Male") && !animalGenderToBuy.equals("Female")){
                    print("\n".repeat(5) + "Input isn't valid, try again!");
                    buyAnimals(currentPlayer);
                }
                print("- Name your new " + animalInput.toLowerCase() + ": ");
                String giveName = scanner.nextLine();
                currentPlayer.addAnimal(new Cow(animalInput, giveName, animalGenderToBuy, 100), currentPlayer);
                currentBalance = currentBalance - Cow.animalPrice;
                currentPlayer.setAccountBalance(currentBalance);
            }
            case "Chicken" -> {
                print("- Alrighty! Do you prefer a male or a female? ");
                var animalGenderToBuy = capitalize(scanner.nextLine().toLowerCase().trim());
                if(!animalGenderToBuy.equals("Male") && !animalGenderToBuy.equals("Female")){
                    print("\n".repeat(5) + "Input isn't valid, try again!");
                    buyAnimals(currentPlayer);
                }
                print("- Name your new " + animalInput.toLowerCase() + ": ");
                String giveName = scanner.nextLine();
                currentPlayer.addAnimal(new Chicken(animalInput, giveName, animalGenderToBuy, 100), currentPlayer);
                currentBalance = currentBalance - Chicken.animalPrice;
                currentPlayer.setAccountBalance(currentBalance);
            }
            default -> {
                print("\n".repeat(5) + "Input isn't valid, try again!");
                buyAnimals(currentPlayer);}
        }
    } catch (Exception error) {
        print("\n".repeat(5) + "Input isn't valid, try again!");
        buyAnimals(currentPlayer);
    }
        print("---" + currentPlayer.getAccountBalance() + "€ left---");
        print("- Would you like to stay?");
        print("(Write \"yes\" to buy another animal or write \"no\" to leave store)");

        String stayOrLeaveInput = scanner.nextLine().toLowerCase();
        if (stayOrLeaveInput.equals("yes")) {
            buyAnimals(currentPlayer);
        }
    }

    public static void buyFood(Player currentPlayer) {
        System.out.println("\n".repeat(10));
        Game.showList(currentPlayer);
        print("- Howdy! Welcome to Joey's Store, what animal are you interested in buying? ");
        print("Hay- " + Hay.foodPrice + "€");
        print("Carrot- " + Carrot.foodPrice + "€");
        print("Seeds - " + Seeds.foodPrice + "€");

        boolean tryAgain = true;
        while (tryAgain) {
            try {
                var foodToBuy = capitalize(scanner.nextLine().toLowerCase().trim());

                print("Alright! How many kilos?");
                var amountOfFood = Integer.valueOf(scanner.nextLine());
                int currentBalance = currentPlayer.getAccountBalance();
                switch (foodToBuy) {
                    case "Hay" -> {
                        currentBalance = currentBalance - (Hay.foodPrice * amountOfFood);
                        currentPlayer.setAccountBalance(currentBalance);
                        currentPlayer.hayFood.setFoodAmount(currentPlayer.hayFood.getAmountOfFood() + amountOfFood);
                    }
                    case "Carrot" -> {
                        currentBalance = currentBalance - (Carrot.foodPrice * amountOfFood);
                        currentPlayer.setAccountBalance(currentBalance);
                        currentPlayer.hayFood.setFoodAmount(currentPlayer.carrotFood.getAmountOfFood() + amountOfFood);
                    }
                    case "Seeds" -> {
                        currentBalance = currentBalance - (Seeds.foodPrice * amountOfFood);
                        currentPlayer.setAccountBalance(currentBalance);
                        currentPlayer.hayFood.setFoodAmount(currentPlayer.seedFood.getAmountOfFood() + amountOfFood);
                    }
                }
                tryAgain = false;
            } catch (Exception error) {
                print("\n".repeat(5) + "Input isn't valid, try again!");
                tryAgain = true;
            }
        }
    }

    public static void sellAnimals(Player currentPlayer){
        System.out.println("\n".repeat(10));
        Game.showList(currentPlayer);
        print("- Howdy! Welcome to Joey's Store, write the number of the animal you would like to sell: ");

        boolean tryAgain = true;
        while(tryAgain) {
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
                    tryAgain = false;
                }
            } catch (Exception error) {
                print("\n".repeat(5) + "Input isn't valid, try again!");
                tryAgain = true;

            }
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

    public static void print(String x){
        if(!x.equals("")){
            System.out.println(x);
        }
    }
}
