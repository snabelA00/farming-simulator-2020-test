package com.company;

public class Animal {

    protected String name;
    protected String gender;
    protected int health;


    public Animal(String name, String gender, int healthPoints){
        this.name = name;
        this.gender = gender;
        this.health = healthPoints;
    }

    //getters
    public String getAnimalName(){
        return name;
    }
    public String getAnimalGender(){ return gender; }
    public int getAnimalHealth(){
        return health;
    }


    //SKa metoden vara här eller i subklassen?
    public void die(){

    }

    public void feedAnimals(){

    }
}
