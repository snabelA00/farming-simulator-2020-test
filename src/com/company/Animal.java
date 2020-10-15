package com.company;

public class Animal {

    protected String name;
    protected String gender;
    protected int hp = 100;

    public Animal(String name, String gender){
        this.name = name;
        this.gender = gender;
    }

    //SKa metoden vara här eller i subklassen?
    public void die(){

    }
}
