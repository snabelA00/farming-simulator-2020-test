package com.company;


import java.io.FileOutputStream;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class Player {

    public static ArrayList<Player> allPlayers = new ArrayList<Player>();
    Map<String, Integer> hm2;

    private String name;
    private int accountBalance;
    ArrayList<Animal> allAnimals;
    Hay hayFood;
    Carrot carrotFood;
    Seeds seedFood;


    public Player(String initialName, int money){
        this.name = initialName;
        this.accountBalance = money;
        this.allAnimals = new ArrayList<Animal>();

        this.hayFood = new Hay(0);
        this.carrotFood = new Carrot(0);
        this.seedFood = new Seeds(0);

        this.hm2 = new HashMap<String, Integer>();
        Player.allPlayers.add(this);
    }

    public void addAnimal(Animal animal, Player currentPLayer){
        this.allAnimals.add(animal);
        Animal.animalHashmap(currentPLayer);
    }

    // getters
    public String getPlayerName(){ return name; }
    public int getAccountBalance(){ return accountBalance;}
    //setters
    public void setAccountBalance(int x){ this.accountBalance = x;}

    public static boolean checkBalance(Player currentPlayer){
        boolean noMoney = false;
        if(currentPlayer.getAccountBalance() == 0){
            noMoney = true;
        }
        return noMoney;
    }

    public static boolean animalLiving(Player currentPlayer){
        boolean gameOver;
        if(currentPlayer.allAnimals.size() == 0){
            gameOver = false;
        } else {
            gameOver = true;
        }
        return gameOver;
    }

}
