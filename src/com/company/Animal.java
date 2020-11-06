package com.company;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class Animal {

    protected String animalSpecie;
    protected String name;
    protected String gender;
    protected int health;
    public abstract int getAnimalPrice();
    private static Scanner scanner = new Scanner(System.in);

    public Animal(String animalSpecie, String name, String gender, int healthPoints){
        this.animalSpecie = animalSpecie;
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

    public static void animalHashmap(Player currentPLayer) {
        currentPLayer.hm2.clear();
        for(Animal animal: currentPLayer.allAnimals) {
            String key = animal.animalSpecie + animal.gender;
            Integer j = currentPLayer.hm2.get(key);
            if (currentPLayer.hm2.containsKey(key) && j != null) {
                currentPLayer.hm2.put(key, j + 1);
            } else {
                currentPLayer.hm2.put(key, 1);
            }
        }
    }

    public static void animalOccurrences(Player currentPlayer){
        for (Map.Entry val : currentPlayer.hm2.entrySet()) {
            System.out.println("Element " + val.getKey() + " "
                    + "occurs"
                    + ": " + val.getValue());
            // System.out.println(val + ": " + Collections.frequency(currentPlayer.allAnimals, val.getKey()));
        }
    }

    public static void animalsMating(Player currentPlayer){
        System.out.println(fiftyFifty());
        System.out.println("Animals mating method called");
        if(currentPlayer.allAnimals.size() >= 2) {
            Animal animalBorn = new Horse("blank", "ken", "Male", 100);
            for (var animal : currentPlayer.allAnimals) {
                var action = animal.animalSpecie;
                switch (action) {
                    case "Horse" -> {
                        if (fiftyFifty() && currentPlayer.hm2.get(animal.animalSpecie + "Male") != null && currentPlayer.hm2.get(animal.animalSpecie + "Female") != null) {
                            String randomGender;
                            System.out.println("In horse swithc");
                            if (fiftyFifty()){randomGender = "Male";
                            } else {
                                randomGender = "Female";
                            }
                            System.out.println("In horse swithc2");
                            System.out.println("A new " + animal.animalSpecie + "was born! (" +  randomGender.toLowerCase() + ")");
                            print("Name your new " + animal.animalSpecie.toLowerCase() + ":");
                            String inputName = scanner.nextLine().trim();
                            animalBorn = new Horse(animal.animalSpecie, inputName, randomGender, 100);
                        }
                    }
                    case "Cow" -> {
                        if (fiftyFifty() && currentPlayer.hm2.get(animal.animalSpecie + "Male") != null && currentPlayer.hm2.get(animal.animalSpecie + "Female") != null) {
                            String randomGender;
                            if (fiftyFifty()){randomGender = "Male";
                            } else {
                                randomGender = "Female";
                            }
                            System.out.println("A new " + animal.animalSpecie + "was born! (" +  randomGender.toLowerCase() + ")");
                            print("Name your new " + animal.animalSpecie.toLowerCase() + ":");
                            String inputName = scanner.nextLine().trim();
                            animalBorn = new Cow(animal.animalSpecie, inputName, randomGender, 100);
                        }
                    }
                    case "Sheep" -> {
                        if (fiftyFifty() && currentPlayer.hm2.get(animal.animalSpecie + "Male") != null && currentPlayer.hm2.get(animal.animalSpecie + "Female") != null) {
                            String randomGender;
                            if (fiftyFifty()){randomGender = "Male";
                            } else {
                                randomGender = "Female";
                            }
                            System.out.println("A new " + animal.animalSpecie + "was born! (" +  randomGender.toLowerCase() + ")");
                            print("Name your new " + animal.animalSpecie.toLowerCase() + ":");
                            String inputName = scanner.nextLine().trim();
                            animalBorn = new Sheep(animal.animalSpecie, inputName, randomGender, 100);
                        }
                    }
                    case "Rabbit" -> {
                        if (fiftyFifty() && currentPlayer.hm2.get(animal.animalSpecie + "Male") != null && currentPlayer.hm2.get(animal.animalSpecie + "Female") != null) {
                            String randomGender;
                            if (fiftyFifty()){randomGender = "Male";
                            } else {
                                randomGender = "Female";
                            }
                            System.out.println("A new " + animal.animalSpecie + "was born! (" +  randomGender.toLowerCase() + ")");
                            print("Name your new " + animal.animalSpecie.toLowerCase() + ":");
                            String inputName = scanner.nextLine().trim();
                            animalBorn = new Rabbit(animal.animalSpecie, inputName, randomGender, 100);
                        }
                    }
                    case "Chicken" -> {
                        if (fiftyFifty() && currentPlayer.hm2.get(animal.animalSpecie + "Male") != null && currentPlayer.hm2.get(animal.animalSpecie + "Female") != null) {
                            String randomGender;
                            if (fiftyFifty()){randomGender = "Male";
                            } else {
                                randomGender = "Female";
                            }
                            System.out.println("A new " + animal.animalSpecie + "was born! (" +  randomGender.toLowerCase() + ")");
                            print("Name your new " + animal.animalSpecie.toLowerCase() + ":");
                            String inputName = scanner.nextLine().trim();
                            animalBorn = new Chicken(animal.animalSpecie, inputName, randomGender, 100);
                        }
                    }
                }
            }
            if(animalBorn.animalSpecie.equals("blank")){
                return;
            } else {
                currentPlayer.addAnimal(animalBorn, currentPlayer);
                animalHashmap(currentPlayer);
            }
        }
    }

    public static void checkAnimalHealth(Player currentPlayer){

        List<Animal> foundDead = new ArrayList<Animal>();
        foundDead.clear();
        for (int i = 0; i < currentPlayer.allAnimals.size(); i++) {
            if (currentPlayer.allAnimals.get(i).getAnimalHealth() <= 0) {
                System.out.println(("- Your " + currentPlayer.allAnimals.get(i).getClass().getSimpleName().toLowerCase()
                        + " " + currentPlayer.allAnimals.get(i).getAnimalName() + " died..."));
                foundDead.add(currentPlayer.allAnimals.get(i));
            } else {
                break;
            }
        }
        currentPlayer.allAnimals.removeAll(foundDead);
        animalHashmap(currentPlayer);
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

    private static final Random random = new Random();
    public static boolean fiftyFifty() {
        if (random.nextBoolean()) {
            return true;
        } else {
            return false;
        }
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
