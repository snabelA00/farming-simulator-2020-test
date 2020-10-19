package com.company;

import java.util.ArrayList;


public class Player {

    public static ArrayList<Player> allPlayers = new ArrayList<Player>();

    private String name;
    private int accountBalance;
    ArrayList<Animal> allAnimals;
    ArrayList<Food> allFood;


    public Player(String initialName, int money){
        this.name = initialName;
        this.accountBalance = money;
        this.allFood = new ArrayList<Food>();
        this.allAnimals = new ArrayList<Animal>();

        Player.allPlayers.add(this);
    }

    public void addAnimal(Animal animal){
        this.allAnimals.add(animal);
    }

    public void addFood(Food food){
        this.allFood.add(food);
    }

    public String getPlayerName(){
        return name;
    }

    public int getAccountBalance(){
        return accountBalance;
    }

    //setters
    public void setAccountBalance(int x){
        this.accountBalance = x;
    }

    /*
    public String getAnimals(){
        return allAnimals;
    }

    public String getFood(){
        return allFood;
    }

     */


}
