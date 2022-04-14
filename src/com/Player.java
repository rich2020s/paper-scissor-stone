package com;
import java.util.Random;

public class Player {
    private String name;
    private int score;
    public Player(String name) {
            this.name = name;
        }

    public String getName() {
        return name;
    }
    public String randomPick(){
        Random r = new Random();
        int randomNumber = r.nextInt(Main.options.length);
        return Main.options[randomNumber];
    }
    public void addScore() {
        score ++;
    }
    public int getScore() {
        return score;
    }
}
