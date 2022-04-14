package com;

import java.util.Scanner;

public class Main {
    /*
	    Create a Rock-Paper-Scissors game that allows 2 people to play against each other.
	    Requirements:
	    - use Scanner to get user input
	    - use control-flow statements to determine the winner and print it out
	    - allow user to repeatedly play games
	    - must create at least one class
	    - Make your own Git Repo and paste the link in the excel sheet.
	    - have the computer randomly pick a an option ("rock", "paper", or "scissors")
	    - Use this link https://www.codegrepper.com/code-examples/java/how+to+select+a+random+element+from+an+array+in+java for assistance with picking a random element from an array
	    Stretch Goals:
	    - allow players to enter their name for a more personalized experience
	    - keep track of score
	    - Extend your game to be tic-tac-toe instead of Rock-Paper-Scissors
	 */
    public static String[] options = {"Paper", "Scissor", "Stone"};
    public static final String paper = options[0];
    public static final String scissor = options[1];
    public static final String stone = options[2];
    public static void main(String[] args) {
        boolean playing = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        Player player = new Player(name);
        Player computer = new Player("Computer");
        System.out.println(computer.getName() + ": Hello " + player.getName() + ". Let's play paper-scissor-stone!\n");

        while(playing) {
            System.out.println("pick one.");
            System.out.println("1. Paper 2. Scissor 3. Stone 4. Quit");
            System.out.println("Please Enter the number of option.");
            int option = scanner.nextInt();
            String computerPick = computer.randomPick();
            if (option <= 4 && option > 0) {
                if (option == 4) {
                    playing = false;
                    System.out.println("See you soon!");
                }
                String playerPick = options[option - 1];
                System.out.println("You choose " + playerPick + " and " + computer.getName() + " choose " + computerPick + ".");
                switch(playerPick) {
                    case "Paper":
                        if (computerPick.equals(paper) ) {
                            System.out.println("Draw.");
                        }
                        else if (computerPick.equals(scissor)) {
                            computer.addScore();
                            System.out.println(computer.getName() + " win!");
                        }
                        else if (computerPick.equals(stone)) {
                            player.addScore();
                            System.out.println("You win!");
                        }
                        break;
                    case "Scissor":
                        if (computerPick.equals(paper)) {
                            player.addScore();
                            System.out.println("You win!");
                        }
                        else if (computerPick.equals(scissor)) {
                            System.out.println("Draw.");
                        }
                        else if (computerPick.equals(stone)) {
                            computer.addScore();
                            System.out.println(computer.getName() + " win!");
                        }
                        break;
                    case "Stone":
                        if (computerPick.equals(paper)) {
                            computer.addScore();
                            System.out.println(computer.getName() + " win!");
                        }
                        else if (computerPick.equals(scissor)) {
                            player.addScore();
                            System.out.println("You win!");
                        }
                        else if (computerPick.equals(stone)) {
                            System.out.println("Draw.");
                        }
                        break;
                }
                System.out.printf("Your score " + player.getScore() + ". Computer's score: " + computer.getScore());
                System.out.println("\n\n");
            } else {
                System.out.println("invalid input.");
                System.out.println(option);
            }
         }
    }
}
