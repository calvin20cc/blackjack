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
    }
}
