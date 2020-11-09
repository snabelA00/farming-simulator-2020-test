package com.company;

public class Sheep extends Animal {

    static int animalPrice = 2000;

    public Sheep(String animalBreed, String name, String gender, int health){
        super(animalBreed, name, gender, health);
    }

    public int getAnimalPrice(){ return animalPrice; }
}
