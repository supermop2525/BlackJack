package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);
    private CardPile deck = new CardPile();

  @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

  @Override
    public void display() {
        System.out.println("House holds: \n"+game.getHouseCards());
        System.out.println("\nYou hold: \n"+game.getYourCards()+"\n");
    }

  @Override
    public boolean hitMe() {
        boolean hit;
        System.out.println("Would you like another card?");
        String input = user.nextLine();
        
        hit = "y".equals(input);
        return hit;
    }

  @Override
    public void gameOver() {
        int houseScore = game.score(game.getHouseCards());
        int yourScore = game.score(game.getYourCards());
        
        System.out.println("Game Over:\n");
        System.out.println("House holds: "+game.getHouseCards()+"\nHouse Score: "+houseScore);
        System.out.println("\nYou hold: "+game.getYourCards()+"\nYour Score: "+yourScore);
        
        if(yourScore > houseScore || houseScore > 21){
            if(yourScore <= 21){
                System.out.println("You win.");
            }else{
                System.out.println("House wins.");
            }
        }else if(houseScore > yourScore || yourScore > 21){
            if(houseScore <= 21){
                System.out.println("House wins.");
            }else{
                System.out.println("bust.");
            }
        }
    }
}
