package com.company;

import java.util.Scanner;

public class Store {

    Scanner scanner = new Scanner(System.in);

    public void buyAnimals(){
        print("- Howdy! Welcome to Joey's Store, what animal are you interested in? ");
        var animalToBuy = capitalize(scanner.nextLine().toLowerCase().trim());
        print("- Alrighty! Do you prefer a male or a female? ");
        var animalGenderToBuy = capitalize(scanner.nextLine().toLowerCase().trim());
        print("- Name your new " + animalToBuy.toLowerCase() + ": ");
        String giveName = scanner.nextLine();
        switch(animalToBuy) {
            case "Horse" -> new Horse(giveName, animalGenderToBuy);
            case "Sheep" -> new Sheep(giveName, animalGenderToBuy);
            case "Rabbit" -> new Rabbit(giveName, animalGenderToBuy);
            case "Cow" -> new Cow(giveName, animalGenderToBuy);
            case "Chicken" -> new Chicken(giveName, animalGenderToBuy);
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
