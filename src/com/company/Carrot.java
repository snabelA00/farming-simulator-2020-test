package com.company;

public class Carrot extends Food{

    static int foodPrice = 15;
    int amountOfFood;
    public Carrot(int amount){
        this.amountOfFood = amount;
    }

    public int getAmountOfFood(){return amountOfFood; }

    public void setFoodAmount(int x){
        this.amountOfFood = x;
    }
}
