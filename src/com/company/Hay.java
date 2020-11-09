package com.company;

public class Hay extends Food{

    static int foodPrice = 25;
    int amountOfFood;

    public Hay(int amount){
        this.amountOfFood = amount;
    }

    public int getAmountOfFood(){return amountOfFood; }

    public void setFoodAmount(int x){
        this.amountOfFood = x;
    }


}
