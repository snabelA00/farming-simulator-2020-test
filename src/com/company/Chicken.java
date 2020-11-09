package com.company;

public class Chicken extends Animal {

    static int animalPrice = 30;

    public Chicken(String animalBreed, String name, String gender, int health){
        super(animalBreed, name, gender, health);
        System.out.println(name + " " + gender);
    }

    public int getAnimalPrice(){ return animalPrice; }
}
