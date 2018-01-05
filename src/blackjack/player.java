/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;

/**
 *
 * @author Calvin Chan
 */
public class player {
    List<card> hand;
    List<Integer> handValues;
    public void deal(card card1, card card2){
        this.hand.add(card1);
        this.hand.add(card2);
        if(card1.symbol == "ace" && card2.symbol == "ace"){
            this.handValues.add(2);
            this.handValues.add(12);
        } else if(card1.symbol == "ace"){
            this.handValues.add(1 + card2.value);
            this.handValues.add(11 + card2.value);
        } else if(card2.symbol == "ace"){
            this.handValues.add(card1.value + 1);
            this.handValues.add(card1.value + 11);
        } else {
            this.handValues.add(card1.value + card2.value);
        }
        cleanHandValues();
        printHandValues();
    }
    public void hit(card card){
        this.hand.add(card);
        if(card.symbol == "ace"){
            int length = handValues.size();
            for(int i = 0; i < length; i++){
                handValues.add(handValues.get(i) + 11);
                handValues.set(i, handValues.get(i) + 1);
            }
        } else {
            int length = handValues.size();
            for(int i = 0; i < length; i++){
                handValues.set(i, handValues.get(i) + card.value);
            }
        }
        cleanHandValues();
        printHandValues();
    }
    public void cleanHandValues(){
        for(int i = 0; i < this.handValues.size(); i++){
            if(this.handValues.get(i) > 21 && this.handValues.size() > 1){
               this.handValues.remove(i);
            }
        }
        this.handValues = this.handValues.stream().distinct().collect(Collectors.toList());
    }
    public void printHandValues(){
        for(Iterator<Integer> iterator = this.handValues.iterator(); iterator.hasNext();){
            System.out.println("value: " + iterator.next());
        }
    }
    public int getMinValue(){
        int min = this.handValues.get(0);
        for(int i = 0; i < this.handValues.size(); i++){
            if(this.handValues.get(i) < min){
                min = this.handValues.get(i);
            }
        }
        return min;
    }
    public int getMaxValue(){
        int max = 0;
        for(int i = 0; i < this.handValues.size(); i++){
            if(this.handValues.get(i) > max){
                max = this.handValues.get(i);
            }
        }
        return max;
    }
    public void resetHand(){
        this.hand.clear();
        this.handValues.clear();
    }
    public player(){
        this.hand = new ArrayList<card>();
        this.handValues = new ArrayList<Integer>();
    }
}
