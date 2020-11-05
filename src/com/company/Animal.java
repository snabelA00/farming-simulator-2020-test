package com.company;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class Animal {

    protected String animalBreed;
    protected String name;
    protected String gender;
    protected int health;
    public abstract int getAnimalPrice();
    protected Scanner scanner = new Scanner(System.in);

    public Animal(String animalBreed, String name, String gender, int healthPoints){
        this.animalBreed = animalBreed;
        this.name = name;
        this.gender = gender;
        this.health = healthPoints;

    }

    //getters
    public String getAnimalName(){
        return name;
    }
    public String getAnimalGender(){ return gender; }
    public int getAnimalHealth(){
        return health;
    }
    //setters
    public void setAnimalHealth(int x){ this.health = x;}

    public static void animalHashmap(Animal animal, Player currentPLayer) {

        String key = animal.animalBreed + animal.gender;
        System.out.println(currentPLayer.hm2.get(key));
        Integer j = currentPLayer.hm2.get(key);
        if (currentPLayer.hm2.containsKey(key) && j != null){
            currentPLayer.hm2.put(key, j + 1);
        }else{
            currentPLayer.hm2.put(key, 1);
        }
    }

    public static void animalOccurrences(Player currentPlayer){
        System.out.println(currentPlayer.getPlayerName());
        for (Map.Entry val : currentPlayer.hm2.entrySet()) {
            System.out.println("Element " + val.getKey() + " "
                    + "occurs"
                    + ": " + val.getValue());
            // System.out.println(val + ": " + Collections.frequency(currentPlayer.allAnimals, val.getKey()));
        }
    }

    public static void animalsMating(Player currentPlayer){
        System.out.println("Animals mating method called");
    }

    public static void checkAnimalHealth(Player currentPlayer){
        for (int i = 0; i < currentPlayer.allAnimals.size(); i++) {
            if (currentPlayer.allAnimals.get(i).getAnimalHealth() <= 0) {
                System.out.println(("- Your " + currentPlayer.allAnimals.get(i).getClass().getSimpleName().toLowerCase()
                        + " " + currentPlayer.allAnimals.get(i).getAnimalName() + " died..."));
                currentPlayer.allAnimals.remove(i);
            }
        }
    }

    public static void feedAnimal(Player currentPlayer){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n".repeat(10));
        Game.showList(currentPlayer);
        int indexAnimal = 0;
        String food = "";
        boolean tryAgain = true;
        while (tryAgain) {
            try {
                print("- Write the number of the animal displayed in the list that you would like to feed:");
                indexAnimal = Integer.valueOf(scanner.nextLine()) - 1;
                var getAnimalClass = currentPlayer.allAnimals.get(indexAnimal).getClass().getSimpleName();

                print("- what do you want do feed " + currentPlayer.allAnimals.get(indexAnimal).getAnimalName() + " with?");
                food = capitalize(scanner.nextLine().toLowerCase().trim());
                boolean returnVal = pickyAnimals(getAnimalClass, food);
                tryAgain = returnVal;
            } catch (Exception error) {
                print("Input isn't valid, try again!");
                tryAgain = true;
            }
        }
                switch (food) {
                    case "Hay" -> currentPlayer.hayFood.setFoodAmount(currentPlayer.hayFood.getAmountOfFood() - 1);
                    case "Carrots" -> currentPlayer.carrotFood.setFoodAmount(currentPlayer.carrotFood.getAmountOfFood() - 1);
                    case "Seeds" -> currentPlayer.seedFood.setFoodAmount(currentPlayer.seedFood.getAmountOfFood() - 1);
                }

                var pickedAnimal = currentPlayer.allAnimals.get(indexAnimal).getAnimalHealth();
                pickedAnimal = pickedAnimal + 10;
                currentPlayer.allAnimals.get(indexAnimal).setAnimalHealth(pickedAnimal);
                print(currentPlayer.allAnimals.get(indexAnimal).getAnimalName() + " +10hp");

            }


    public static void reduceHealth(Player currentPLayer) {
        for (var eachAnimal : currentPLayer.allAnimals) {
            int reduceHp = (int) (Math.random() * (50 - 30)) + 30;
            var index = currentPLayer.allAnimals.indexOf(eachAnimal);
            var getHp = currentPLayer.allAnimals.get(index).getAnimalHealth();
            var setHp = getHp - reduceHp;
            currentPLayer.allAnimals.get(index).setAnimalHealth(setHp);
        }
    }

    public static boolean pickyAnimals(String animalClass, String food) {
        boolean returnVal = true;
        if (food.equals("Hay")) {
            if (animalClass.equals("Horse") || animalClass.equals("Cow") || animalClass.equals("Sheep")) {
                returnVal = false;
            }
        } else if (food.equals("Carrots")) {
            if (animalClass.equals("Horse") || animalClass.equals("Rabbit")) {
                returnVal = false;
            }
        } else if (food.equals("Seeds")) {
            if (animalClass.equals("Chicken") || animalClass.equals("Rabbit")) {
                returnVal = false;
            }
        } else {
            returnVal = true;
        }
        if (returnVal){
            print("Your " + animalClass.toLowerCase() + " won't eat " + food.toLowerCase());
        }
        return returnVal;
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
