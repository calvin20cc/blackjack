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
    String[] symbols = {"ace","king","queen","jack","2","3","4","5","6","7","8","9","10"};
    // Print Deck Method
    public void printDeck(){
        for(int i = 0; i < this.cardArray.length; i++){
            System.out.println(this.cardArray[i].symbol + " of " + this.cardArray[i].suit);
        }
    }
    // Constructor
    public deck(){
        this.cardArray = new card[52];
        for(int i = 0; i < this.cardArray.length; i++){
            this.cardArray[i] = new card(symbols[i%13], suits[i%4]);
        }
    }
}
