package com.company;

public class Rabbit extends Animal {

    static int animalPrice = 20;

    public Rabbit(String animalBreed, String name, String gender, int health){
        super(animalBreed, name, gender, health);
    }

    public int getAnimalPrice(){ return animalPrice; }
}
