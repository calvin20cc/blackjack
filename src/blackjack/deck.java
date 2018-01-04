/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author Calvin Chan
 */
import java.io.*;

public class deck {
    // Properties
    card[] cardArray;
    String[] suits = {"clubs","diamonds","hearts","spades"};
    //String[] symbols = {"ace","king","queen","jack","2","3","4","5","6","7","8","9","10"};
    String[] symbols = {"ace","ace","ace","ace","ace","ace","ace","5","6","7","8","ace","ace"};
    // Print Deck Method
    public void printDeck(){
        for(int i = 0; i < this.cardArray.length; i++){
            System.out.println(this.cardArray[i].symbol + " of " + this.cardArray[i].suit);
        }
    }
    // Draw Card Method
    public card drawCard(){
        int random = (int)(Math.random() * 51);
        while(this.cardArray[random].drawn){
            random = (int)(Math.random() * 51);
        }
        System.out.println(this.cardArray[random].symbol + " of " + this.cardArray[random].suit);
        this.cardArray[random].drawn = true;
        return this.cardArray[random];
    }
    public void shuffle(){
        for(int i = 0; i < this.cardArray.length; i++){
            this.cardArray[i].drawn = false;
        }
        System.out.println("deck is shuffled");
    }
    // Constructor
    public deck(){
        this.cardArray = new card[52];
        for(int i = 0; i < this.cardArray.length; i++){
            this.cardArray[i] = new card(symbols[i%13], suits[i%4]);
        }
    }
}
