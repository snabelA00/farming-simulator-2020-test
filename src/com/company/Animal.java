package com.company;

public abstract class Animal {

    protected String name;
    protected String gender;
    protected int health;
    public abstract int getAnimalPrice();

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
    //setters
    public void setAnimalHealth(int x){ this.health = x;}

    public static void reduceHealth(Player currentPLayer) {
        for (var eachAnimal : currentPLayer.allAnimals) {
            //Math.random()*(maximum - minimum) + minimum
            int reduceHp = (int) (Math.random() * (50 - 40)) + 40;
            var index = currentPLayer.allAnimals.indexOf(eachAnimal);
            var getHp = currentPLayer.allAnimals.get(index).getAnimalHealth();
            var setHp = getHp - reduceHp;
            currentPLayer.allAnimals.get(index).setAnimalHealth(setHp);
        }
    }

    public static void checkAnimalHealth(Player currentPlayer){
        for (int i = 0; i < currentPlayer.allAnimals.size(); i++) {
            if (currentPlayer.allAnimals.get(i).getAnimalHealth() <= 0) {
                System.out.println(("- Your " + currentPlayer.allAnimals.get(i).getClass().getSimpleName().toLowerCase()
                        + " " + currentPlayer.allAnimals.get(i).getAnimalName() + " died..."));
                currentPlayer.allAnimals.remove(i);
            }
        }
    }

}
