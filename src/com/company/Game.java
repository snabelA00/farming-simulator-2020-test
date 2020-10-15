package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    Scanner scanner = new Scanner(System.in);
    private ArrayList<String> playerNames = new ArrayList<>();

    public Game(){
        print("\n".repeat(1));
        print("F A R M I N G  S I M U L A T O R  -  2 0 2 0 \n(1 - 4 players)");
        //Start game
        //Print line
        // how many rounds?
        //how many players?
        print("\n".repeat(1));
        print("- How many players are you?");
        int numberOfPlayers = Integer.valueOf(scanner.nextLine());
        //initialize players
        print("- Write the name of all the players");
        for(var i = 1; i <= numberOfPlayers; i++) {
            print("- Spelare " + (i) + ":s namn: ");
            playerNames.add(scanner.nextLine());
        }

        print(playerNames.toString());

        print("- How many rounds would you like to play? Choose between 5 - 30:");
        int xRounds = Integer.valueOf(scanner.nextLine());

        main(xRounds);
    }



    public void main(int numberOfRounds){
        for(int i = 1; i <= numberOfRounds; i++){
            print("- Lets begin!\n" + "");
        }

    }

    public void print(String x){
        if(!x.equals("")){
            System.out.println(x);
        }
    }
}
