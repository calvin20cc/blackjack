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
public class card {
    String symbol;
    int value;
    String suit;
    boolean drawn;
    public card(String symbol, String suit){
        this.symbol = symbol;
        this.suit = suit;
        this.drawn = false;
        if(this.symbol == "king" || this.symbol == "queen" || this.symbol == "jack"){
            this.value = 10;
        } else if(this.symbol == "ace"){
            this.value = 1;
        } else {
            this.value = Integer.parseInt(this.symbol);
        }
    }
}
