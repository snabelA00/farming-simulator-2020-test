package com.company;

public class Chicken extends Animal {

    static int animalPrice = 30;

    public Chicken(String name, String gender, int health){
        super(name, gender, health);
        System.out.println(name + " " + gender);
    }

    public int getAnimalPrice(){ return Chicken.animalPrice; }
}
