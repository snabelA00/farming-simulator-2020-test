package com.company;

public class Rabbit extends Animal {

    static int animalPrice = 20;

    public Rabbit(String name, String gender, int health){
        super(name, gender, health);
    }

    public int getAnimalPrice(){ return Rabbit.animalPrice; }
}
