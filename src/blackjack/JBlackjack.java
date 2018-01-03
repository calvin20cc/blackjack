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
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class JBlackjack extends JPanel{
  // Properties
  public boolean blnuppressed = false;
  public boolean blndownpressed = false;
  public boolean blnwpressed = false;
  public boolean blnspressed = false;
  public boolean blnStart = false;
  public boolean blnrepaint = true;
  public deck deckStart = new deck();
  public int winnings = 5000;
  public int bet = 0;
  public player player1 = new player();
  public player dealer = new player();
  
  @Override
  public void paintComponent(Graphics g){
    Graphics2D g2d = (Graphics2D)g;
    g2d.clearRect(0, 0, 800, 600);
    g2d.drawString(Integer.toString(winnings), 375, 500);
  }
  
  public static void pause(int intMS){
    try{
      Thread.sleep(intMS);
    }catch(InterruptedException e){
    }
  }
  
  // Constructor
  public JBlackjack(){
    super();
  }
}
