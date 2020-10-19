package com.company;

public class Cow extends Animal {

    static int animalPrice = 4000;

    public Cow(String name, String gender, int health){
        super(name, gender, health);
        System.out.println(name + " " + gender);
    }

    public int getAnimalPrice(){ return Cow.animalPrice; }
}
