package com.company;


public class Horse extends Animal {

    static int animalPrice = 5000;

    public Horse(String animalBreed, String name, String gender, int health){
        super(animalBreed, name, gender, health);
    }

    public int getAnimalPrice(){ return animalPrice; }
}
