package com.company;

public class Seeds extends Food{

    static int foodPrice = 10;
    int amountOfFood;

    public Seeds(int amount){
        this.amountOfFood = amount;
    }


    public int getAmountOfFood(){return amountOfFood; }

    public void setFoodAmount(int x){
        this.amountOfFood = x;
    }

}
