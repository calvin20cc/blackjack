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

public class Blackjack implements ActionListener, MouseListener, MouseMotionListener, KeyListener{
  // Properties
  public JFrame theframe;
  public JBlackjack thepanel; //Instead of JPanel
  public Timer thetimer;
  public JButton dealbut, hitbut, standbut;
  
  // Methods
  public void actionPerformed(ActionEvent evt){
    if(thepanel.blnrepaint == true){
      if(evt.getSource() == thetimer){
        thepanel.repaint();
      }
    }
    if(evt.getSource() == dealbut){
      //theframe.requestFocus();
      theframe.setSize(800, 600);
      thepanel.removeAll();
      thepanel.repaint();
      //thepanel.revalidate();  
      thepanel.add(hitbut);
      thepanel.add(standbut);
      thepanel.player1.deal(thepanel.deckStart.drawCard(), thepanel.deckStart.drawCard());
      thepanel.dealer.deal(thepanel.deckStart.drawCard(), thepanel.deckStart.drawCard());
      if(thepanel.player1.getMaxValue() == 21 && thepanel.dealer.getMaxValue() == 21){
          System.out.println("PUSH");
          hitbut.setEnabled(false);
      } else if(thepanel.player1.getMaxValue() == 21){
          System.out.println("WIN");
          hitbut.setEnabled(false);
      } else if(thepanel.dealer.getMaxValue() == 21){
          System.out.println("LOSE");
          hitbut.setEnabled(false);
      }
    }
    if(evt.getSource() == hitbut){
      thepanel.player1.hit(thepanel.deckStart.drawCard());
      System.out.println(thepanel.player1.getMinValue());
      if(thepanel.player1.getMaxValue() == 21){
          hitbut.setEnabled(false);
          evt.setSource(standbut);
      }
      if(thepanel.player1.getMinValue() > 21){
          System.out.println("BUST");
          hitbut.setEnabled(false);
          standbut.setEnabled(false);
      }
    }
    if(evt.getSource() == standbut){
        System.out.println("player 1: " + thepanel.player1.getMaxValue());
        if(thepanel.player1.getMaxValue() < 16){
            while(thepanel.dealer.getMaxValue() < 17){
                thepanel.dealer.hit(thepanel.deckStart.drawCard());
            }
        }
        System.out.println("dealer: " + thepanel.dealer.getMaxValue());
        if(thepanel.dealer.getMaxValue() > 21){
            System.out.println("WIN");
        } else if(thepanel.dealer.getMaxValue() < thepanel.player1.getMaxValue()){
            System.out.println("WIN");
        } else if(thepanel.dealer.getMaxValue() == thepanel.player1.getMaxValue()){
            System.out.println("PUSH");
        } else{
            System.out.println("LOSE");
        }
        thepanel.deckStart.shuffle();
        hitbut.setEnabled(false);
        standbut.setEnabled(false);
    }
  }
  
  public void mousePressed(MouseEvent evt){
    //System.out.println("pressed");
  }
  
  public void mouseReleased(MouseEvent evt){
    //System.out.println("released");
  }
  
  public void mouseClicked(MouseEvent evt){
//    System.out.println("clicked");
//    System.out.println(evt.getX());
//    System.out.println(evt.getY());
//    System.out.println(evt.getButton());
    if(evt.getX() > 0 && evt.getX() < 100 && evt.getY() > 0 && evt.getY() < 100 && evt.getButton() == 3){
      
    }
  }
  
  public void mouseExited(MouseEvent evt){
    //System.out.println("exited");
  }
  
  public void mouseEntered(MouseEvent evt){
    //System.out.println("entered");
  }
  
  public void mouseDragged(MouseEvent evt){
    //System.out.println("mouse dragged (" + evt.getX() + "," + evt.getY() + ")");
  }
  
  public void mouseMoved(MouseEvent evt){
    //System.out.println("mouse moved (" + evt.getX() + "," + evt.getY() + ")");

  }
  
  public void keyPressed(KeyEvent evt){
    //System.out.println(evt.getKeyCode() + " key pressed");
    if(evt.getKeyCode() == KeyEvent.VK_UP){
      thepanel.blnuppressed = true;
    }else if(evt.getKeyCode() == KeyEvent.VK_DOWN){
      thepanel.blndownpressed = true;
    }
    if(evt.getKeyCode() == KeyEvent.VK_W){
      thepanel.blnwpressed = true;
    }else if(evt.getKeyCode() == KeyEvent.VK_S){
      thepanel.blnspressed = true;
    }
    if(evt.getKeyCode() == KeyEvent.VK_SPACE){
      thepanel.blnStart = true;
    }
  }
  
  public void keyReleased(KeyEvent evt){
    //System.out.println(evt.getKeyCode() + " key released");
    if(evt.getKeyCode() == KeyEvent.VK_UP){
      thepanel.blnuppressed = false;
    }else if(evt.getKeyCode() == KeyEvent.VK_DOWN){
      thepanel.blndownpressed = false;
    }
    if(evt.getKeyCode() == KeyEvent.VK_W){
      thepanel.blnwpressed = false;
    }else if(evt.getKeyCode() == KeyEvent.VK_S){
      thepanel.blnspressed = false;
    }
  }
  
  public void keyTyped(KeyEvent evt){
    //System.out.println(evt.getKeyChar() + " key typed");
  }
  // Constructors
  public Blackjack(){
    theframe = new JFrame("BlackJack");
    theframe.setSize(800, 600);
    theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    thepanel = new JBlackjack();
    thepanel.addMouseListener(this);
    thepanel.addMouseMotionListener(this);
    theframe.addKeyListener(this);
    thepanel.setLayout(null);
    
    dealbut = new JButton("Deal");
    dealbut.setSize(100, 25);
    dealbut.setLocation(600, 400);
    dealbut.addActionListener(this);
    thepanel.add(dealbut);
    
    hitbut = new JButton("Hit");
    hitbut.setSize(100, 25);
    hitbut.setLocation(600, 400);
    hitbut.addActionListener(this);
    
    standbut = new JButton("Stand");
    standbut.setSize(100, 25);
    standbut.setLocation(600, 430);
    standbut.addActionListener(this);
    
    theframe.setContentPane(thepanel);
    theframe.setVisible(true);
    
    thetimer = new Timer(1000/30, this);
    thetimer.start();
  }
  
  // Main method
  public static void main(String[] args){
    Blackjack game = new Blackjack();
  }
}