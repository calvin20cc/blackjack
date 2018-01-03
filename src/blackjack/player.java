/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Calvin Chan
 */
public class player {
    List<card> hand;
    int totalValue;
    public void deal(card card1, card card2){
        this.hand.add(card1);
        this.hand.add(card2);
        this.totalValue += card1.value + card2.value;
        System.out.println(this.totalValue);
    }
    public void hit(card card){
        this.hand.add(card);
        this.totalValue += card.value;
        System.out.println(this.totalValue);
    }
    public player(){
        this.hand = new ArrayList<card>();
        this.totalValue = 0; 
    }
}
