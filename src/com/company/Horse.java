package com.company;


public class Horse extends Animal {

    static int animalPrice = 5000;

    public Horse(String name, String gender, int health){
        super(name, gender, health);
    }

    public int getAnimalPrice(){ return Horse.animalPrice; }
}
