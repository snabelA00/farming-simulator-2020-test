package com.company;

public class Sheep extends Animal {

    static int animalPrice = 2000;

    public Sheep(String name, String gender, int health){
        super(name, gender, health);
    }

    public int getAnimalPrice(){ return Sheep.animalPrice; }
}
