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
  
  // Methods
  public void actionPerformed(ActionEvent evt){
    if(thepanel.blnrepaint == true){
      if(evt.getSource() == thetimer){
        thepanel.repaint();
      }
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