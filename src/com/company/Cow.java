package com.company;

public class Cow extends Animal {

    static int animalPrice = 4000;

    public Cow(String animalBreed, String name, String gender, int health){
        super(animalBreed, name, gender, health);
    }

    public int getAnimalPrice(){ return animalPrice; }
}
