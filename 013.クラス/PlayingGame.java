/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

/**
 *
 * @author guest1Day
 */
public class PlayingGame {
    public static void main(String[] args){
    System.out.println("D：U1");
    
    //ディール    
    Dealer dealer1 = new Dealer();
    User user1 = new User();
 
    dealer1.myCards.addAll(dealer1.deal());
    System.out.println(dealer1.open());
    
    user1.myCards.addAll(dealer1.deal());
    System.out.println("  "+user1.open());
    int forWhile = 0;
    while(forWhile==0){
    
    //チキンレースじゃオラぁ（switc文にできそう/メソッドにもできる？）
        dealer1.myCards.addAll(dealer1.hit());
        System.out.println(dealer1.open());
        if(dealer1.checkSum()==false){
            System.out.println("Congratulations!あなたの勝ちです！");
            forWhile++;           
        }

        if(forWhile!=0){
            continue;
        }
        user1.myCards.addAll(dealer1.hit());
        System.out.println("  "+user1.open());
        if(user1.checkSum()==false){
            System.out.println("You're defeated...残念");
            forWhile++;
        }
    }
    

    }
}
